<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div align="center">
  <img src="img/logo.png" width="400" />
  &emsp;&emsp;&emsp;&emsp;
  <img src="img/cselogo.png" width="400" />
  </div>
  <div align="center">
  	<h1>课程作业管理系统</h1>
  
    <form method="post" action="LoginController" name="form1">
    <fieldset style="border-radius:13px; width:400px;">
		<legend align="center">个人信息</legend>
			<br>
			用&emsp;户:&emsp;<input type="text" name="user" style="width:200px; height:20px;text-align:center;">
			<br><br>
			密&emsp;码:&emsp;<input type="password" name="password" style="width:200px; height:20px;text-align:center;">
			<br><br>
			验证码:&emsp;<input type="text" name="checktext" style="width:90px; height:20px;text-align:center;vertical-align:middle;">
			 <canvas id="canvas" width="100px" height="25px" onclick="dj()" 
	  		 style="border: 1px solid #ccc;
        	 border-radius: 5px;vertical-align:middle;"></canvas>
			<br>
			<br>
				<select name="academy" onChange="getDepartment();" style="width:275px;height:27px">
					<option value="0">请选择所在学院</option>
					<option value="计算机科学与工程学院">计算机科学与工程学院</option>
					<option value="电子工程与光电技术学院">电子工程与光电技术学院</option>
				</select>
				<br>
				<br>
				<select name="department" style="width:275px;height:27px">
					<option value="0">请选择所在专业</option>
				</select>
						
			<br>
			<br>
			
			
			<input type="submit" value="登录">
			&emsp;&emsp;&emsp;
			<a href="https://github.com/KendrickKan">帮助</a>
			&emsp;&emsp;&emsp;
			<a href="https://github.com/KendrickKan">忘密</a>
			</fieldset>
		</form>
		</div>
  </body>
  
  <script>
 var show_num = [];
 draw(show_num);
function dj(){
 draw(show_num);   
 }
function sublim(){
var val=document.getElementById("text").value;  
            var num = show_num.join("");
            if(val==''){
                alert('请输入验证码！');
            }else if(val == num){
                alert('提交成功！');
                document.getElementById(".input-val").val('');
                draw(show_num);

            }else{
                alert('验证码错误！\n你输入的是:  '+val+"\n正确的是:  "+num+'\n请重新输入！');
                document.getElementById("text").value='';
                draw(show_num);
            }
        
       
		
          }
function draw(show_num) {
        var canvas_width=document.getElementById('canvas').clientWidth;
        var canvas_height=document.getElementById('canvas').clientHeight;
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度
			
        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt;
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 15 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }
function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
    
    
    var department=[
    ["计算机科学与技术","软件工程","智能科学与技术","网络空间安全"],
    ["电子科学与技术","电子信息工程","光电信息科学与工程","通信工程","微电子科学与工程"]
    ];
    function getDepartment(){
    	var sltacademy = document.form1.academy;
    	var sltdepartment = document.form1.department;
    	var academyDepartment = department[sltacademy.selectedIndex - 1];
    	
    	sltdepartment.length=1;
    	
    	for(var i=0;i<academyDepartment.length;i++)
    	{
    		sltdepartment[i+1]=new Option(academyDepartment[i],academyDepartment[i]);
    	}
    }
    
    
</script>
  
  
</html>
