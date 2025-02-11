package ra.jv240502_nguyenhuuchung.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;



public class CloudinaryService {


        private final Cloudinary cloudinary;

        public CloudinaryService() {
            this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "YOUR_CLOUD_NAME",
                    "api_key", "YOUR_API_KEY",
                    "api_secret", "YOUR_API_SECRET"
            ));
        }

        public String uploadFile(MultipartFile file) {
            try {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                return uploadResult.get("url").toString(); // Lấy URL ảnh sau khi upload
            } catch (IOException e) {
                throw new RuntimeException("Lỗi upload file", e);
            }
        }
    }


