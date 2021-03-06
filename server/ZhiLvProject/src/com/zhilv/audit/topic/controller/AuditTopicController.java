package com.zhilv.audit.topic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.audit.topic.service.AuditTopicService;
import com.zhilv.entity.AuditTopic;
import com.zhilv.entity.Topic;
import com.zhilv.topic.service.TopicService;
import com.zhilv.util.DateUtil;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;

/**   
 * @ClassName: AuditTopicController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:18:17       
 */
@Controller
@RequestMapping("audit/topic")
public class AuditTopicController {
	
	@Resource
	private AuditTopicService auditTopicService;
	
	@Resource
	private TopicService TopicService;
	
	@RequestMapping(value="/list/{pageNum}/{status}",method=RequestMethod.GET)
	public String list(@PathVariable("status")int status, @PathVariable(value="pageNum",required=true)int pageNum, Model model) {
		List<AuditTopic> list = auditTopicService.findForPage(status,(pageNum-1)*FinalUtil.PAGE_SIZE,FinalUtil.PAGE_SIZE);
		Page<AuditTopic> page = new Page<>(pageNum,FinalUtil.PAGE_SIZE);
		page.setList(list);
		page.setTotalCount(auditTopicService.findTopicCount(status));
		model.addAttribute("topicPage",page);
		model.addAttribute("status", status);
		return "topic-list";
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(@RequestParam("title")String title,@RequestParam("userId")Integer userId) {
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setUserId(userId);
		int i = auditTopicService.addAuditTopic(topic);
		if(i > 0) {
			System.out.println("审核版话题添加成功");
			return "OK";
		}else {
			System.out.println("审核版话题添加失败");
			return "ERROR";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@RequestParam("auditId")Integer auditId,@RequestParam("status")Integer status) {
		int i = auditTopicService.updateTopicStatus(auditId, status, DateUtil.getCurrentTimes());
		if(i > 0) {
			System.out.println("审核版话题状态更新成功");
			if(status == 1) { //通过审核则添加发布版话题
				AuditTopic auditTopic = auditTopicService.findAuditTopicById(auditId);
				Topic topic = new Topic();
				topic.setTitle(auditTopic.getTitle());
				topic.setUserId(auditTopic.getUserId());
				int j = TopicService.addTopic(topic);
				if(j > 0) {
					System.out.println("话题发布成功");
					return "OK";
				}else {
					System.out.println("话题发布失败");
					return "ERROR";
				}
			}
			return "OK";
		}else {
			System.out.println("审核版话题状态更新失败");
			return "ERROR";
		}
	}

}
