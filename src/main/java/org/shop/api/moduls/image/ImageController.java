package org.shop.api.moduls.image;

import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Log
@RestController
@RequestMapping("/images")
public class ImageController {

    @GetMapping("/byte1/{imageNo}")
    public ResponseEntity<byte[]> byte1Image(@PathVariable Integer imageNo) throws IOException {
        log.info("byte1" + imageNo);

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream("C:/mbr/files/4.jpg");

            headers.setContentType(MediaType.IMAGE_JPEG);

            entity = new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }

        return entity;
    }

    @GetMapping("/byte2/{imageNo}")
    public ResponseEntity<byte[]> byte2Image(@PathVariable Integer imageNo) throws IOException {
        log.info("byte2" + imageNo);

        String fileName = "4.jpg";

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream("C:/mbr/files/" + fileName);

            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.add("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

            entity = new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }

        return entity;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        log.info("originalName: " + originalFilename);

        ResponseEntity<String> entity = new ResponseEntity<>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
        return entity;
    }
}
