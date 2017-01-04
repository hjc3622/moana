<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
电影票抢购系统demo
</head>
<body>

<table >

</table>

<script type="text/javascript">
function func(movieId){
   	window.location.href="http://localhost:8080/moana/snap/"+ movieId ;
   	console.error(movieId+"---------");
  }
			$.ajax({
			 type:'GET', //指定提交的数据为post方法
			 dataType:'json', //指定获取数据的方法是json，也就是说服务器必须返回json形式的数据
			 url:"http://localhost:8080/moana/list", //获取的地址，注意跨域名获取的问题
		//	 data:'', //这是post方式提交的具体参数
			 success:function(res){ //个就是提交后并功能获取数据，res就是json的原格式数据
			      var jsonarr = eval(res); //就是执行一次json数据转为js对象的数组，eval()生成对象也要注意貌似有两种形式，这里不多自己研究     
			   //  ...有了jsonarr数据，下面就使用JQuery的方法显示出来就行了
               var str="";
               str+="<tr><td>电影名称</td><td>数量</td><td>开始时间</td><td>结束时间</td><td>创建时间</td><td>操作</td></tr>";
               $.each(jsonarr.mt,function(i,item){
                   var movieId=item.movie_id;
                   var name=item.name;
                   var number=item.number;
                   var startTime=item.startTime;
                   var endTime=item.endTime;
                   var createTime=item.createTime;
                   str+="<tr>"+"<td>"+name+"</td>"+"<td>"+number+"</td>"+"<td>"+startTime+"</td>"+"<td>"+endTime+"</td>"+"<td>"+createTime+"</td>"+"<td><input type='button' value='抢票'  onclick='func("+movieId+")'></td>"+"</tr>";
			    })
			   $("table").append(str);
			    },
			 error:function () {
                 console.error("login error!");
             } //如果post方法失败或获取json数据失败的处理
			})
	
	</script>

</body>
</html>