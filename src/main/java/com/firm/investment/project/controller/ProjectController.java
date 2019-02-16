package com.firm.investment.project.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.uitls.FileHelper;
import com.firm.investment.base.uitls.JsonBackData;
import com.firm.investment.project.entity.ProjectAssessoryEntity;
import com.firm.investment.project.entity.ProjectEntity;
import com.firm.investment.project.entity.ProjectProgressEntity;
import com.firm.investment.project.entity.ProjectMothReportEntity;
import com.firm.investment.project.service.IProjectAssessoryService;
import com.firm.investment.project.service.IProjectFlowStepService;
import com.firm.investment.project.service.IProjectMothReportService;
import com.firm.investment.project.service.IProjectProgressService;
import com.firm.investment.project.service.IProjectService;
import com.firm.investment.project.vo.AreaVO;
import com.firm.investment.project.vo.InvestMoneyAndRateVO;
import com.firm.investment.project.vo.ProjectAssessoryVO;
import com.firm.investment.project.vo.ProjectFlowStepVO;
import com.firm.investment.project.vo.ProjectProgressVO;
import com.firm.investment.project.vo.ProjectMothReportVO;
import com.firm.investment.project.vo.ProjectVO;

@Controller
@RequestMapping(value="project")
public class ProjectController {

	private static Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	private IProjectService service;
	@Autowired
	private IProjectProgressService progressService;
	@Autowired
	private IProjectFlowStepService flowStepService;
	@Autowired
	private IProjectMothReportService reportService;
	
	@Autowired
	private IProjectAssessoryService assessoryService;

	@RequestMapping(value = "queryProjectById")
	@ResponseBody
	public JsonBackData findProjectById(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectVO vo = service.findVOById(id, ProjectVO.class);
			back.setBackData(JSON.toJSON(vo).toString());
			back.setSuccess(true);
			back.setBackMsg("查询重点项目信息成功！");

		} catch (Exception e) {
			logger.error("根据Id查询重点项目方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询重点项目信息失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryAssessUnitProjectList")
	@ResponseBody
	public JsonBackData findProjectList(@RequestParam String areaId,@RequestParam int level) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectVO> vos = service.findAssessUnitProjectList(areaId,level);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("查询市/县重点项目列表成功！");

		} catch (Exception e) {
			logger.error("查询市/县重点项目列表方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询市/县重点项目列表失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryAssessUnitPrjByName")
	@ResponseBody
	public JsonBackData queryAssessUnitPrjsByName(@RequestParam String name) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectVO> vos = service.findAssessUnitPrjsByName(name);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("根据市名称查询市/县重点项目列表成功！");

		} catch (Exception e) {
			logger.error("根据市名称查询市/县重点项目列表方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据市名称查询市/县重点项目列表失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryAreaList")
	@ResponseBody
	public JsonBackData queryAreaList() {
		JsonBackData back = new JsonBackData();
		try {
			List<AreaVO> vos = service.findAssessUnitProjectArea();
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("查询重点项目区域信息成功！");

		} catch (Exception e) {
			logger.error("查询重点项目区域方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询重点项目区域失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonBackData save(@RequestBody ProjectVO vo) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectVO revo = service.save(vo, ProjectEntity.class, ProjectVO.class);
			back.setBackData(JSON.toJSONString(revo));
			back.setSuccess(true);
			back.setBackMsg("保存成功！");

		} catch (Exception e) {
			logger.error("保存重点项目信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryInvestMoneyAndRate")
	@ResponseBody
	public JsonBackData queryInvestMoneyAndRate() {
		JsonBackData back = new JsonBackData();
		try {
			InvestMoneyAndRateVO vo = service.queryInvestMoneyAndRate();
			back.setBackData(JSON.toJSON(vo).toString());
			back.setSuccess(true);
			back.setBackMsg("查询项目的投资额和项目开工率成功！");

		} catch (Exception e) {
			logger.error("查询项目的投资额和项目开工率方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询项目的投资额和项目开工率失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryProjectList")
	@ResponseBody
	public JsonBackData queryProjectList(@RequestParam Map<String,Object> sreachPrarm) {
		JsonBackData back = new JsonBackData();
		//logger.error("【根据项目条件搜索项目参数】-------------【"+sreachPrarm+"】");
		try {
			List<ProjectVO> vos = service.queryProjectList(sreachPrarm);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("根据项目条件搜索项目成功！");

		} catch (Exception e) {
			logger.error("根据项目条件搜索项目方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据项目条件搜索项目失败," + e.getMessage());
		}
		return back;
	}
	
	
	@RequestMapping(value = "updateProjectState")
	@ResponseBody
	public JsonBackData updateProjectState(@RequestParam String id,@RequestParam int actionType) {
		JsonBackData back = new JsonBackData();
		try {
			service.updateProjectState(id,actionType);
			back.setSuccess(true);
			back.setBackMsg("项目状态修改成功！");

		} catch (Exception e) {
			logger.error("项目状态修改方法：", e);
			back.setSuccess(false);
			back.setBackMsg("项目状态修改失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "savePjtFlowStep")
	@ResponseBody
	public JsonBackData savePjtFlowStep(@RequestBody ProjectFlowStepVO vo) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectFlowStepVO reVO= flowStepService.saveProjectFlowStepWithProjectId(vo);
			back.setBackData(JSON.toJSON(reVO).toString());
			back.setSuccess(true);
			back.setBackMsg("保存项目进展节点成功！");

		} catch (Exception e) {
			logger.error("保存项目进展节点方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存项目进展节点失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "deletePjtFlowStep")
	@ResponseBody
	public JsonBackData deletePjtFlowStep(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			flowStepService.delete(id);
			back.setSuccess(true);
			back.setBackMsg("根据Id删除项目进展节点成功！");

		} catch (Exception e) {
			logger.error("根据Id删除项目进展节点方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据Id删除项目进展节点失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryPjtFlowStepByPjtId")
	@ResponseBody
	public JsonBackData queryPjtFlowStepByPjtId(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectFlowStepVO> vos = flowStepService.queryByProjectId(id);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("根据项目ID查询项目进展节点成功！");

		} catch (Exception e) {
			logger.error("根据项目ID查询项目进展节点方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据项目ID查询项目进展节点失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryInterestPjtIdByUserId")
	@ResponseBody
	public JsonBackData queryInterestPjtIdByUserId(@RequestParam String userId) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectVO> vos = service.queryInterestPjtIdByUserId(userId);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("根据用户ID查询关注项目信息成功！");

		} catch (Exception e) {
			logger.error("根据用户ID查询关注项目信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据项目ID关注查询项目信息失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "saveProjectProgress")
	@ResponseBody
	public JsonBackData saveProjectProgress(@RequestBody ProjectProgressVO vo) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectProgressVO reVO= progressService.save(vo,ProjectProgressEntity.class,ProjectProgressVO.class);
			back.setBackData(JSON.toJSON(reVO).toString());
			back.setSuccess(true);
			back.setBackMsg("保存项目进展/项目效能数据成功！");

		} catch (Exception e) {
			logger.error("保存项目进展/项目效能数据方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存项目进展/项目效能数据失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "deleteProjectProgress")
	@ResponseBody
	public JsonBackData deleteProjectProgress(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			progressService.delete(id);
			back.setSuccess(true);
			back.setBackMsg("删除项目进展/项目效能数据成功！");

		} catch (Exception e) {
			logger.error("删除项目进展/项目效能数据方法：", e);
			back.setSuccess(false);
			back.setBackMsg("删除项目进展/项目效能数据失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryPjtProgressById")
	@ResponseBody
	public JsonBackData queryPjtProgressById(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectProgressVO vo = progressService.findVOById(id, ProjectProgressVO.class);
			back.setBackData(JSON.toJSON(vo).toString());
			back.setSuccess(true);
			back.setBackMsg("根据ID查询项目进展/项目效能数据成功！");

		} catch (Exception e) {
			logger.error("根据ID查询项目进展/项目效能数据方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据ID查询项目进展/项目效能数据失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryPjtProgressByStepId")
	@ResponseBody
	public JsonBackData queryPjtProgressByStepId(@RequestParam String stepId) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectProgressVO> vo = progressService.queryPjtProgressByStepId(stepId);
			back.setBackData(JSON.toJSON(vo).toString());
			back.setSuccess(true);
			back.setBackMsg("根据stepID查询项目进展/项目效能数据成功！");

		} catch (Exception e) {
			logger.error("根据stepID查询项目进展/项目效能数据方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据stepID查询项目进展/项目效能数据失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryPjtProgressByPjtId")
	@ResponseBody
	public JsonBackData queryPjtProgressByPjtId(@RequestParam String projectId) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectProgressVO> vos =progressService.queryPjtProgressByPjtId(projectId);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("根据项目进度ID查询项目进展/项目效能数据成功！");

		} catch (Exception e) {
			logger.error("根据项目ID查询项目进展/项目效能数据方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据项目ID查询保存项目进展/项目效能数据失败," + e.getMessage());
		}
		return back;
	}
	
	
	@RequestMapping(value = "queryPjtMothReport")
	@ResponseBody
	public JsonBackData queryPjtMothReport(@RequestParam Map<String,Object> sreachPrarm) {
		JsonBackData back = new JsonBackData();
		try {
			List<ProjectMothReportVO> vos = reportService.queryPjtMothReport(sreachPrarm);
			back.setBackData(JSON.toJSON(vos).toString());
			back.setSuccess(true);
			back.setBackMsg("查询月度报告成功！");

		} catch (Exception e) {
			logger.error("查询月度报告方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询月度报告失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "savePjtMothReport")
	@ResponseBody
	public JsonBackData savePjtMothReport(@RequestBody ProjectMothReportVO vo) {
		JsonBackData back = new JsonBackData();
		try {
			ProjectMothReportVO reVo = reportService.save(vo, ProjectMothReportEntity.class, ProjectMothReportVO.class);
			back.setBackData(JSON.toJSON(reVo).toString());
			back.setSuccess(true);
			back.setBackMsg("保存月度报告成功！");

		} catch (Exception e) {
			logger.error("保存月度报告方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存月度报告失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value="upload")
	@ResponseBody
    public JsonBackData upload(HttpServletRequest request,@RequestParam String fileName,@RequestParam MultipartFile bannerImage)  {
		JsonBackData back = new JsonBackData();
		
		try {
			// 如果文件不为空，写入上传路径
			if (fileName !=null && !fileName.equals("")) {
				// 上传文件路径
				String rootpath = request.getServletContext().getRealPath("");
				String filePath = rootpath + "/assessory/";
				fileName = FileHelper.upload(filePath,bannerImage);
				ProjectAssessoryVO vo = new ProjectAssessoryVO();
				String contextPath = request.getContextPath()+"/assessory/";
				vo.setPath(contextPath.replaceAll("\\\\", "/"));
				vo.setName(fileName);
				vo.setTransStatus("1");
				vo.setIsImage(new BigDecimal(1));
				vo.setTotalPage(new BigDecimal(0));
				vo.setFileSize(new BigDecimal(bannerImage.getSize()));
				ProjectAssessoryVO projectAssessoryVO = assessoryService.save(vo, ProjectAssessoryEntity.class,
						ProjectAssessoryVO.class);
				AssessoryVO reVo = new AssessoryVO();
				reVo.setId(projectAssessoryVO.getId());
				reVo.setCreateTime(projectAssessoryVO.getCreateTime());
				reVo.setName(projectAssessoryVO.getName());
				reVo.setDelFlag(0);
				reVo.setUrl("/project/download?fileName="+fileName);
				back.setBackData(JSON.toJSON(reVo).toString());	
				back.setSuccess(true);
				back.setBackMsg("上传成功！");
			} else {
				back.setSuccess(false);
				back.setBackMsg("没有文件可以上传！");
			}
		} catch (Exception e) {
			logger.error("附件上传方法：", e);
			back.setSuccess(false);
			back.setBackMsg("上传失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("fileName") String fileName) throws Exception {
		// 下载文件路径
		String rootpath = request.getServletContext().getRealPath("");
		String filePath = rootpath + "/assessory/";
		return FileHelper.download(filePath, fileName);
	}
}
