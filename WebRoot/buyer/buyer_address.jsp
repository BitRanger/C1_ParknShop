<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div id="new_address">Add New Address</div>
    <form  id="address_div">
        <div id="address_district">
            <label style="margin-top: 5px" class="address_label left">District</label>
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
        <div>
            <label class="address_label">Zip Code</label>
            <input class="address_input" type="text" name="zipcode">
        </div>
        <div>
            <label class="address_label">Street</label>
            <textarea id="address_street" name="street"
                   placeholder="No need to write district again, just street, no more than 200 characters"></textarea>
        </div>
        <div>
            <label class="address_label">Receiver</label>
            <input class="address_input" type="text" name="receiver" placeholder="no more than 50 characters">
        </div>
        <div>
            <label class="address_label">PhoneNum</label>
            <input class="address_input" type="text" name="phonenum">
        </div>
        <div style="margin-left: 95px">
            <input id="address_button" type="button" name="confirm" value="confirm" onclick="confirm_address()">
        </div>
    </form>
</div>

<div style="margin-top: 50px;">
    <div id="saved_address">Saved Address</div>
    <table id="saveAddressTable">
        <tr style="background-color: #e4e4e4">
            <th>Receiver</th>
            <th>District</th>
            <th>Street</th>
            <th>Zipcode</th>
            <th>PhoneNum</th>
            <th>Operation</th>
        </tr>
        <tr>
            <td>Yang Kaidi</td>
            <td>陕西省 西安市 莲湖区</td>
            <td>劳动南路80号</td>
            <td>710072</td>
            <td>13466821234</td>
            <td><a href="#">Modify</a> <a href="#">Delete</a></td>
        </tr>
        <tr>
            <td>Yang Kaidi</td>
            <td>陕西省 西安市 莲湖区</td>
            <td>劳动南路80号</td>
            <td>710072</td>
            <td>13466821234</td>
            <td><a href="#">Modify</a> <a href="#">Delete</a></td>
        </tr>
    </table>
</div>
























