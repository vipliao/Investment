package com.firm.investment.assessory.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firm.investment.assessory.service.IAssessoryService;
import com.firm.investment.base.uitls.JsonBackData;
@Controller
@RequestMapping(value="assessory")
public class AssessoryController {

	private static Logger logger = LoggerFactory.getLogger(AssessoryController.class);
	@Autowired
	private IAssessoryService service;
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonBackData delete(@RequestBody List<String> ids) {
		JsonBackData back = new JsonBackData();
		try {
			service.deleteBatch(ids.toArray(new String[ids.size()]));
			back.setSuccess(true);
			back.setBackMsg("删除成功！");

		} catch (Exception e) {
			logger.error("附件删除方法：", e);
			back.setSuccess(false);
			back.setBackMsg("删除失败," + e.getMessage());
		}
		return back;
	}
	 
	@RequestMapping(value = "download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename) throws Exception {
		// 下载文件路径
		String rootpath = request.getServletContext().getRealPath("");
		String path = rootpath + "/assessory/";
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
