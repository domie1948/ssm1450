<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>卖家发布商品</title>
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/seller-pub-goods.css">
</head>
<body>
<%@include file="index_header.jsp" %>

<!--***content***-->
<div class="main">
    <div class="common">
        <div class="content-top mt-30">
            发布商品
        </div>
        <div class="form-content mt-10">
            <form action="front_goodsAction_doPub" method="post" enctype="multipart/form-data" onsubmit="return validateForm(this)">
                <div class="form-group  clear">
                    <div class="form-group-left">
                        选择分类：
                    </div>
                    <div class="form-group-right">
                        <div class="form-group-right-area">
                            <select name="goods.cata" type="text" class="form-control">
                                <option value="1">方便零食</option>
                                <option value="2">奶蛋制品</option>
                                <option value="3">饮料酒水</option>
                                <option value="4">生活用品</option>
                                <option value="5">咖啡冲饮</option>
                                <option value="6">日用百货</option>
                                <option value="7">新鲜水果</option>
                                <option value="8">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="form-group  clear">
                    <div class="form-group-left">
                        商品名称：
                    </div>
                    <div class="form-group-right">
                        <input type="text" name="goods.name" class="form-control" placeholder="商品名称">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="form-group  clear">
                    <div class="form-group-left">
                        商品价格：
                    </div>
                    <div class="form-group-right">
                        <input type="text" name="goods.price" class="form-control" placeholder="88">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="form-group  clear">
                    <div class="form-group-left">
                        商品库存：
                    </div>
                    <div class="form-group-right">
                        <input type="text" name="goods.sum" class="form-control" placeholder="88">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="form-group-upload  clear">
                    <div class="form-group-left">
                        商品图片：
                    </div>
                   <!--  <div class="form-group-right-upload">

                    </div> -->
                    <input type="file" name="uploadFile">  
					<input type="hidden" value=ext name="uploadFileContentType">         
                    <div class="clear"></div>
                </div>
                <div class="form-group-save">
                    <div class="content-save-btn">
                        <button type="submit">保存</button>
                    </div>
                </div>

            </form>
        </div>

    </div>
</div>

</body>
<script src="<%=path %>/js/jquery-1.11.3.min.js"></script>
<script Language="JavaScript" Type="text/javascript">

       function validateForm(frmUpload) {

                //检查是否提交了上传文件否弹出提示不需要这一功能的删除即可   

              if (document.all.uploadFile.value == "")

              {

                     alert("没有选择上传的文件！");

                     frmUpload.uploadFile.focus();

                     return false;

              }     

                //截取提交上传文件的扩展名  

              var ext = frmUpload.uploadFile.value.match(/^(.*)(\.)(.{1,8})$/)[3];

              ext = ext.toLowerCase(); //设置允许上传文件的扩展名           

              if (ext ==  "jpg" || ext == "gif" || ext=="png") {
					
                     return true;

              } else {

                     alert("只允许上传 .jpg或gif 或png文件，请重新选择需要上传的文件！");

                     return false;

              }

       }

</script>
</html>