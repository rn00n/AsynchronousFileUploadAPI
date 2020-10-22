package org.shop.api.infra.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import lombok.extern.java.Log;

@Log
public class UploadFileUtils {
	/**
	 * 파일 업로드
	 * @param uploadPath
	 * @param originalName
	 * @param fileData
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		// UUID 발급
		UUID uid = UUID.randomUUID();

		// 저장할 파일명 = UUID_원본이름
		String savedName = uid.toString() + "_" + originalName;

		// 업로드할 디렉토리(날짜별 폴더) 생성
		String savedPath = calcPath(uploadPath);

		// 파일 경로(기존의 업로드 경로 + 날짜별경로)
		File target = new File(uploadPath + savedPath, savedName);

		// 임시 디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(fileData, target);

		// 썸네일을 생성하기 위한 파일의 확장자 검사
		// 파일명이 aaa.bbb.ccc.jpg일 경우 마지막 마침표를 찾기 위해
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		
		String uploadedFileName =  savedPath.replace(File.separatorChar, '/') + '/' +  savedName;

		// 이미지 파일은 썸네일 사용
		if (MediaUtils.getMediaType(formatName) != null) {
			// 썸네일 생성
			makeThumbnail(uploadPath, savedPath, savedName);
		} 
		
		return uploadedFileName;
	}

	/**
	 * 썸네일 생성
	 * @param uploadPath
	 * @param path
	 * @param fileName
	 * @throws Exception
	 */
	private static void makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		// 이미지를 읽기 위한 버퍼
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

		// 100픽셀 단위의 썸네일 생성
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);

		// 썸네일의 이름을 생성(원본파일명에 's_'를 붙임)
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		// 썸네일 생성
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
	}

	/**
	 * 날짜별 디렉토리 추출
	 * @param uploadPath
	 * @return
	 */
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();

		// File.separator : 디렉토리 구분자(\\)
		// 연도, ex) \\2020
		String yearPath = File.separator + cal.get(Calendar.YEAR);

		// 월, ex) \\2020\\10
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);

		// 날짜, ex) \\2020\\10\\22
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		// 디렉토리 생성 메서드 호출
		makeDir(uploadPath, yearPath, monthPath, datePath);

		log.info(datePath);

		return datePath;
	}

	/**
	 * 디렉토리 생성
	 * @param uploadPath
	 * @param paths
	 */
	private static void makeDir(String uploadPath, String... paths) {
		// 디렉토리가 존재하면
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		// 디렉토리가 존재하지 않으면
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);

			// 디렉토리가 존재하지 않으면
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

}
