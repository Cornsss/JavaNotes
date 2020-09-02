package Network;

import com.alibaba.fastjson.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class EstateInterfaceTest {
    public static void main(String[] args) throws Exception {
        testEstateInterface3();
    }
    //http协议访问外部接口测试（不动产查询接口）
	/*public static void testEstateInterface() throws Exception{
		ResourceBundle res = ResourceBundle.getBundle("cmis");
		String ip = res.getString("estate.info.ip");
		String port = res.getString("estate.info.port");
		String username = res.getString("estate.info.username");
		String password = res.getString("estate.info.password");

		JSONObject req = new JSONObject(); // 整个JSON请求报文
		req.put("username", username);
		req.put("password", password);
		System.out.println("获取token请求参数：" + req.toString());
//		String urlToken ="http://"+ip+":"+port+"/estateplat-public/static/swagger-ui/index.html#!/tokenapi/getToken";
		String urlToken ="http://"+ip+":"+port+"/estateplat-public/rest/api/v1/access_token";
		HttpClient httpConnector = new HttpClient();

		HttpURLConnection connection = httpConnector.getConnection(urlToken, "POST");

		int responseCode = httpConnector.send(connection, req.toString().getBytes("UTF-8"));

		connection.connect();
		byte[] receive = httpConnector.receive(connection);

        System.out.println(new String(receive));
        String content = new String(receive);
        JSONObject fromObject = JSONObject.fromObject(content);
        JSONObject object = (JSONObject) fromObject.get("data");
        String string = object.getString("token");
        System.out.println("token------------" + string);
		System.out.println(responseCode);

//		urlToken ="http://"+ip+":"+port+"/estateplat-public/static/swagger-ui/index.html#!/sharecqapi/cqzxxEnc?token="+string;
		urlToken ="http://"+ip+":"+port+"/estateplat-public/rest/cqxx/v3/cqzxx?token="+string;
		HttpURLConnection connection2 = httpConnector.getConnection(urlToken, "POST");
		JsonObject reqDataEstate = new JsonObject();
		JsonObject reqDataEstateHead = new JsonObject();
		reqDataEstateHead.addProperty("username", username);//授权用户名
		reqDataEstateHead.addProperty("password", password);//授权密码
		reqDataEstateHead.addProperty("regioncode", "");//行政区代码
		reqDataEstateHead.addProperty("token", string);//安全令牌
		reqDataEstateHead.addProperty("orgid", "");//查询机构标识
		reqDataEstateHead.addProperty("size", 10);//分页每页大小
		reqDataEstateHead.addProperty("page", 1);//分页页码
		reqDataEstate.add("head", reqDataEstateHead);
		JsonObject reqDataEstateBody = new JsonObject();
		reqDataEstateBody.addProperty("bdcqzh","");//产权证号
		reqDataEstateBody.addProperty("qlrzjh ","321181197802106765");//权利人证件号
		reqDataEstateBody.addProperty("qlrmc","朱红霞");//权利人名称
		reqDataEstateBody.addProperty("cqzt",true);
		reqDataEstate.add("data", reqDataEstateBody);
		System.out.println("===============请求参数：");
		System.out.println(reqDataEstate);

		int send = httpConnector.send(connection2, reqDataEstate.toString().getBytes("UTF-8"));
		connection2.connect();
		byte[] receive2 = httpConnector.receive(connection2);
		JSONObject estateJson = JSONObject.fromObject(new String(receive2));
		System.out.println("===============响应参数：");
		System.out.println(estateJson);
		JSONArray object2 = (JSONArray)estateJson.get("data");
		for (int i = 0; i < object2.size(); i++) {
			System.out.println(object2.get(i));
		}
	}*/

    /*@SuppressWarnings("deprecation")
    public static void testEstateInterface2() throws Exception{
        HttpGet httpPost = null;
        ResourceBundle res = ResourceBundle.getBundle("cmis");
        String ip = res.getString("estate.info.ip");
        String port = res.getString("estate.info.port");
        String username = res.getString("estate.info.username");
        String password = res.getString("estate.info.password");

        JSONObject req = new JSONObject(); // 整个JSON请求报文
        req.put("username", username);
        req.put("password", password);
        System.out.println("获取token请求参数：" + req.toString());
        String urlToken ="http://"+ip+":"+port;
//		String urlToken ="http://"+ip+":"+port+"/estateplat-public/rest/api/v1/access_token";
        System.out.println("请求地址：====" +urlToken);
        HttpClient client = new DefaultHttpClient();
        httpPost = new HttpGet(urlToken);
        if (req != null) {
            StringEntity se = new StringEntity(req.toString(), "utf-8");
//			httpPost.setEntity(se); // post方法中，加入json数据
            httpPost.setHeader("Content-Type", "application/json");
        }
        HttpResponse response=client.execute(httpPost);
        System.out.println("返回数据：====="+response);
        HttpEntity entity = response.getEntity();
        String contentType = entity.getContentType()==null?null:entity.getContentType().toString();
        if(contentType==null || contentType.toLowerCase().indexOf("application/json")!=-1){///返回JSON字符串
            String string = EntityUtils.toString(entity);//返回JSON字符串
            System.out.println(string);
        }
    }*/

    public static void testEstateInterface3() throws Exception{
        String ret = "";
        HttpURLConnection connection = null;
        String urlToken ="http://218.3.120.98:9002/estateplat-public/rest/api/v1/access_token";
        URL url = new URL(urlToken);
        System.out.println("请求地址：====" +urlToken);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();
        OutputStream os = connection.getOutputStream();
        JSONObject req = new JSONObject(); // 整个JSON请求报文
        req.put("username", "nshjk");
        req.put("password", "123456");
        System.out.println("获取token请求参数：" + req.toString());
        os.write(req.toString().getBytes("UTF-8"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

        StringBuffer sb = new StringBuffer();
        String temp = "";
        while ((temp = reader.readLine()) != null) {
            temp = new String(temp.getBytes("UTF-8"), "UTF-8");
            sb.append(temp);
        }
        ret = sb.toString();
        JSONObject parse = (JSONObject) JSONObject.parse(ret);
        JSONObject data = parse.getJSONObject("data");
        String token = (String) data.get("token");

        System.out.println("token数据：====="+token);
        String urlEstata ="http://218.3.120.98:9002/estateplat-public/rest/cqxx/v3/cqxx-qlrzjh";
        url = new URL(urlEstata);
        System.out.println("请求地址：====" +urlEstata);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();
        os = connection.getOutputStream();

        JSONObject reqDataEstate = new JSONObject();
        JSONObject reqDataEstateHead = new JSONObject();
        reqDataEstateHead.put("username", "nshjk");//授权用户名
        reqDataEstateHead.put("password", "123456");//授权密码
        reqDataEstateHead.put("regioncode", "");//行政区代码
        reqDataEstateHead.put("token", token);//安全令牌
        reqDataEstateHead.put("orgid", "");//查询机构标识
        reqDataEstateHead.put("size", 10);//分页每页大小
        reqDataEstateHead.put("page", 1);//分页页码
        reqDataEstate.put("head", reqDataEstateHead);
        JSONObject reqDataEstateBody = new JSONObject();
        reqDataEstateBody.put("bdcqzh","");//产权证号
        reqDataEstateBody.put("qlrzjh ","321181197802106765");//权利人证件号
        reqDataEstateBody.put("qlrmc","朱红霞");//权利人名称
        reqDataEstateBody.put("cqzt",true);
        reqDataEstate.put("data", reqDataEstateBody);
        System.out.println("===============请求参数：");
        System.out.println(reqDataEstate);
        os.write(reqDataEstate.toString().getBytes("UTF-8"));
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

        sb = new StringBuffer();
        temp = "";
        while ((temp = reader.readLine()) != null) {
            temp = new String(temp.getBytes("UTF-8"), "UTF-8");
            sb.append(temp);
        }
        ret = sb.toString();
        System.out.println("响应数据：====="+ret);
    }
}
