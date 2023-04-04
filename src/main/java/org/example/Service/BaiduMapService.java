package org.example.Service;

import org.example.Model.Employee;
import org.example.Model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiduMapService {
//    public List<Location> selectAllEmployee() {
//        return
//    }
//    public Location find(String LocationId) {
//        Location location = new Location();
//        location.setLocationName();
//        location.setLocationId();
//        location.setLatitude();
//        location.setLongtitude();
//        place.setName(placeName);
//        place.setRegion(region);
////        ak  一把钥匙
//        String assessToken = "VOgW3BhCAV05YZkOyUGkHUndPw59DA0n";
////        发送请求   超时未连接断开
//        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(20)).build();
//        HttpResponse response = null;
//        try{
////            终端节点
//            String endPoint = "https://api.map.baidu.com/place/v2/search?";
//            URI uri = URI.create(endPoint + "query="+placeName+"&region="+region + "&output=json" + "&ak=" + assessToken);
//            System.out.println(uri);
//            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (Exception e) {
////            打印错误
//            e.printStackTrace();
//        }
//        System.out.println("Status Code" + response.statusCode());
//        System.out.println("Body" + response.body());
////          转换格式
//        JSONObject placeJSON = null;
//        try {
//            placeJSON = new JSONObject(response.body().toString());
//        }catch (Exception e) {
//            System.out.println("paesing error");
//        }
////        经纬转换
//        try {
////            得到第一个经纬，在进行Json里的定位  json体-jsonobject
//            String lng = placeJSON.getJSONArray("results").getJSONObject(0).getJSONObject("location").getString("lng");
//            String lat = placeJSON.getJSONArray("results").getJSONObject(0).getJSONObject("location").getString("lat");
//            place.setLat(lat);
//            place.setLng(lng);
//        }catch (Exception e){
//            System.out.println("getting error");
//        }
//        return place;
//    }
}
