<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function test() {
            var data = $("#form").serializeObject();
            var str = JSON.stringify(data);
            alert(str);
        }

        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    </script>
</head>
<body>
<form id="form" action="#" method="post">
    id: <input type="text" name="id"/><br/>
    name:<input type="text" name="name"/><br/>
    age:<input type="text" name="age"/><br/>
    <input type="button" value="click" onclick="test();"/>
</form>
</body>
</html>