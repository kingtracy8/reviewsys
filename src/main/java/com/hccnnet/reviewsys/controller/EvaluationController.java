package com.hccnnet.reviewsys.controller;

import com.hccnnet.reviewsys.domain.Evaluation;
import com.hccnnet.reviewsys.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by trcay on 2018/9/7.
 */
@Controller
@RequestMapping(value = "/evaluation")
public class EvaluationController {

    @Autowired
    IEvaluationService evaluationService;

    @RequestMapping(value = "/tbinterface", method = RequestMethod.GET)
    public @ResponseBody
    HashMap EvaluationList(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        HashMap map = new HashMap();
        Evaluation evaluation = new Evaluation();
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        int start = (Integer.valueOf(page)-1)*Integer.valueOf(limit);
        int offset = Integer.valueOf(limit);
        List<Evaluation> evaluations = evaluationService.selectByTeacherId(employeeId,start,offset);
        map.put("code", 0);
        map.put("msg", "");
        int count = evaluationService.selectCountByTeacherId(employeeId);
        map.put("count",count);
        map.put("data", evaluations);
        return map;
    }


    @RequestMapping("/doEvaluation")
    public String doApplyCpt(HttpServletRequest request, Model model) {
        return "evaluation";
    }


    /**
     *  通过id寻找评价表的记录，用来返回给初始化页面
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/evaluationInfoById", method = RequestMethod.GET)
    public @ResponseBody
    Evaluation doFindById(HttpServletRequest request, HttpServletResponse response) {

        int elId;
        elId = Integer.parseInt(request.getParameter("elId"));
        Evaluation evaluation = evaluationService.selectByPrimaryKey(elId);
        return evaluation;
    }


    /**
     *  导师评语接口
     * @param request
     * @param response
     * @param evaluation
     * @return
     */
    @RequestMapping(value = "/updateReview")
    public @ResponseBody HashMap doUpdateReview(HttpServletRequest request, HttpServletResponse response, @RequestBody Evaluation evaluation){

        HashMap map = new HashMap();
        int flag = -1;

        int t1Id = evaluation.getT1Id();
        int t2Id = evaluation.getT2Id();
        int leaderId = evaluation.getDeptLeaderId();

        //判断是哪一个指导老师
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        if(employeeId == t1Id){
            evaluation.setT1Ischeck(1);
        }else if (employeeId == t2Id){
            evaluation.setT2Ischeck(1);
        }else if(employeeId == leaderId){
            evaluation.setDeptLeaderIscheck(1);
        }

        flag = evaluationService.updateByPrimaryKeySelective(evaluation);

        map.put("flag", flag);
        return map;
    }


}
