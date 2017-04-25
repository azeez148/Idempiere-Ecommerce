<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Multi File</title>
</head>
<body>
   <jsp:include page="menu.jsp"/>
    
   <h3>Upload Multiple File:</h3>
    
    <!-- MyUploadForm -->
    <form:form modelAttribute="myUploadForm" method="POST"
                        action="" enctype="multipart/form-data">
         
        Description:
        <br>
        <form:input path="description" style="width:300px;"/>                
        <br/><br/>                 
     
        File to upload (1): <form:input path="fileDatas" type="file"/><br />      
        File to upload (2): <form:input path="fileDatas" type="file"/><br />    
        File to upload (3): <form:input path="fileDatas" type="file"/><br />    
        File to upload (4): <form:input path="fileDatas" type="file"/><br />    
        File to upload (5): <form:input path="fileDatas" type="file"/><br />    
         
        <input type="submit" value="Upload">
          
    </form:form>
     
     
</body>
</html>