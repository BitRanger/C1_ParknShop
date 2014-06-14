<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>

<div>
    <form id="publish_form">
        <div>
            <label class="common_label">Username</label>
            <input class="common_input" type="text" name="name">
        </div>
        <div>
            <label class="common_label">Category</label>
            <input class="common_btn" onclick="choose_category()" type="button" value="Please choose">
        </div>
        <div>
            <label class="common_label">Price</label>
            <input class="common_input" type="text" name="price" placeholder="Price">
            <input class="common_input" type="text" name="promotion" placeholder="Promotion">
        </div>
        <div>
            <label class="common_label">Contact</label>
            <input class="common_input" type="text" name="sellername" placeholder="Your name">
            <input class="common_input" type="text" name="phonenum" placeholder="Phone Number">
        </div>
        <div>
            <label class="common_label left">Image</label>
            <div id="uploadDiv">
                <div id="uploadImages"></div>
                <div id="upload">
                    <a href="javascript:void(0)" onclick="uploadImage()">
                        <img src="images/upload.JPG">
                    </a>
                    <input style="display: none" id="imgFile" type="file"
                           name="imgFile" onchange="previewImage(this)">
                </div>
            </div>
            <div style="margin: 0 0 15px 95px;">
                No more than 5 images, and each image's size should less than 5M
            </div>
        </div>

        <div>
            <label class="common_label left">Description</label>
            <textarea id="publish_goodsDesc"></textarea>
        </div>

        <br>
        <div id="bigShowTitle">And here, you can give your product detail. Just Hit It!</div>
        <div>
            <textarea name="editor1" id="bigshow"></textarea>
            <script>
                CKEDITOR.replace( 'bigshow' );
            </script>
        </div>
    </form>
</div>











