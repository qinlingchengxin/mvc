<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        var myArray =new Array();

        myArray[0]=new Person(1,"a",26);
        myArray[1]=new Person(2,"b",27);
        myArray[2]=new Person(3,"c",28);
        var jsonString=JSON.stringify(myArray);
        console.log(jsonString)

        function Person(id,name,age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
    </script>
</head>
<body>
<form method="post" action="servlet/upload" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>