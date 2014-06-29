<%@page import="com.bitranger.parknshop.admin.data.PsAdministrator"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <ul id="basicInfo_nav" class="nav nav-tabs">
        <li><a href="#basicInfo_avatar" data-toggle="tab">Avatar</a></li>
        <li class="active"><a href="#basicInfo_basic" data-toggle="tab">Basic</a></li>
        <li><a href="#basicInfo_education" data-toggle="tab">Education</a></li>
        <li><a href="#basicInfo_work" data-toggle="tab">Work</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane" id="basicInfo_avatar">
            <script type="text/javascript">
                function uploadevent(status,picUrl,callbackdata){
                    //alert(picUrl); //后端存储图片
                    //	alert(callbackdata);
                    status += '';
                    switch(status){
                        case '1':
                            var time = new Date().getTime();
                            var filename162 = picUrl+'_162.jpg';
                            // var filename48 = picUrl+'_48.jpg';
                            // var filename20 = picUrl+"_20.jpg";

                            var realUrl = filename162.substr(2);

                            //document.getElementById('avatar_priview').innerHTML = "头像1 : <img src='"+filename162+"?" + time + "'/> <br/> 头像2: <img src='"+filename48+"?" + time + "'/><br/> 头像3: <img src='"+filename20+"?" + time + "'/>" ;
                            $("#adminAvatarImg").attr("src", "util/" + realUrl);
                            break;
                        case '-1':
                            window.location.reload();
                            break;
                        default:
                            window.location.reload();
                    }
                }
            </script>
            <div id="altContent">
                <OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
                        WIDTH="650" HEIGHT="450" id="myMovieName">
                    <PARAM NAME=movie VALUE="util/avatar.swf">
                    <PARAM NAME=quality VALUE=high>
                    <PARAM NAME=bgcolor VALUE=#FFFFFF>
                    <param name="flashvars" value="imgUrl=util/default.jpg&uploadUrl=util/upfile.jsp&uploadSrc=false" />
                    <EMBED src="util/avatar.swf" quality=high bgcolor=#FFFFFF WIDTH="650" HEIGHT="450" wmode="transparent"
                           flashVars="imgUrl=util/default.jpg&uploadUrl=util/upfile.jsp&uploadSrc=false"
                           NAME="myMovieName" ALIGN="" TYPE="application/x-shockwave-flash" allowScriptAccess="always"
                           PLUGINSPAGE="http://www.adobe.com/go/getflash">
                    </EMBED>
                </OBJECT>
            </div>
            <div id="avatar_priview"></div>
        </div>
        <div class="tab-pane active" id="basicInfo_basic">
        <% PsAdministrator curAdmin = (PsAdministrator)request.getAttribute("cur_admin");
        %>
            <form id="basicInfo_div">
                <div>
                    <label class="basicInfo_label">Username</label>
                    <input class="basicInfo_input" type="text" name="username" value="<%= curAdmin.getName() %>">
                </div>
                <div>
                    <label class="basicInfo_label">E-mail</label>
                    <input class="basicInfo_input" type="text" name="email" value="<%= curAdmin.getEmail() %>">
                </div>
                <div style="height: 75px">
                    <label class="basicInfo_label left">Gender</label>
                    <div class="left" id="gender_select">
                        <input type="radio" checked="checked" name="gender" value="male">male<br>
                        <input type="radio" name="gender" value="female">female<br>
                        <input type="radio" name="gender" value="other">other<br>
                    </div>
                </div>
                <div id="hometown">
                    <label class="basicInfo_label left">Howetown</label>
                    <div class="left" >
                        <select class="select" name="province" id="s1">
                            <option></option>
                        </select>
                        <select class="select" name="city" id="s2">
                            <option></option>
                        </select>
                        <select class="select" name="town" id="s3">
                            <option></option>
                        </select><br>
                    </div>
                </div>
                <div style="margin-left: 90px; margin-top: 30px">
                    <input style="width: 80px" class="common_btn" value="Confirm">
                </div>
            </form>
        </div>
        <div class="tab-pane" id="basicInfo_education">
            ewe
        </div>
        <div class="tab-pane" id="basicInfo_work">hhh
        </div>
    </div>
</div>
