package com.example.indivisual.img.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

public class ImgService {
  @Value("${spring.upload.image.location}")
  String folder;
  void ImageUpload(MultipartFile multipartFile) throws IOException {
// 2. 서버에 파일 저장 & DB에 파일 정보(fileinfo) 저장
// - 동일 파일명을 피하기 위해 random값 사용
    String originalFilename = multipartFile.getOriginalFilename();
    String saveFileName = createSaveFileName(originalFilename);

// 2-1.서버에 파일 저장
    multipartFile.transferTo(new File(getFullPath(saveFileName)));

///////////////////////////////////////////////////////////////////////////////

  }
  // 파일 저장 이름 만들기
// - 사용자들이 올리는 파일 이름이 같을 수 있으므로, 자체적으로 랜덤 이름을 만들어 사용한다
  String createSaveFileName(String originalFilename) {
    String ext = extractExt(originalFilename);
    String uuid = UUID.randomUUID().toString();
    return uuid + "." + ext;
  }

  // 확장자명 구하기
  String extractExt(String originalFilename) {
    int pos = originalFilename.lastIndexOf(".");
    return originalFilename.substring(pos + 1);
  }

  // fullPath 만들기
  String getFullPath(String filename) {
    return folder + filename;
  }

}
