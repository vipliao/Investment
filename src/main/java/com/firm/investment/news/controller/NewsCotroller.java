package com.firm.investment.news.controller;

import java.util.List;
import java.util.UUID;

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
import com.firm.investment.assessory.entity.AssessoryEntity;
import com.firm.investment.assessory.service.IAssessoryService;
import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.uitls.FileHelper;
import com.firm.investment.base.uitls.JsonBackData;
import com.firm.investment.news.entity.NewsEntity;
import com.firm.investment.news.service.INewsService;
import com.firm.investment.news.vo.NewsVO;

@Controller
@RequestMapping(value="news")
public class NewsCotroller {

	private static Logger logger = LoggerFactory.getLogger(NewsCotroller.class);
	@Autowired
	private INewsService service;
	@Autowired
	private IAssessoryService assessoryService;

	@RequestMapping(value = "queryLaterNews")
	@ResponseBody
	public JsonBackData queryLaterNews(@RequestParam int actionType) {
		JsonBackData back = new JsonBackData();
		try {
			List<NewsVO> newsList = service.queryLaterNews(actionType);
			back.setBackData(JSON.toJSON(newsList).toString());
			back.setSuccess(true);
			back.setBackMsg("查询最新通报/招商引资成功！");

		} catch (Exception e) {
			logger.error("查询最新通报/招商引资方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询最新通报/招商引资失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "saveLaterNews")
	@ResponseBody
	public JsonBackData saveLaterNews(@RequestBody NewsVO vo) {
		JsonBackData back = new JsonBackData();
		try {
			NewsVO news = service.save(vo, NewsEntity.class, NewsVO.class);
			back.setBackData(JSON.toJSON(news).toString());
			back.setSuccess(true);
			back.setBackMsg("保存最新通报成功！");

		} catch (Exception e) {
			logger.error("保存最新通报方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存最新通报失败," + e.getMessage());
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
				AssessoryVO vo = new AssessoryVO();
				String contextPath = request.getContextPath()+"/assessory/";
				vo.setPath(contextPath.replaceAll("\\\\", "/"));
				vo.setName(fileName);
				vo.setUrl("/news/download?fileName="+fileName);
				AssessoryVO reVo = assessoryService.save(vo, AssessoryEntity.class,
						AssessoryVO.class);
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
