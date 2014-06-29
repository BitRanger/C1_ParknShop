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
            <label class="common_label">Name</label>
            <input class="common_input" type="text" name="name" id="name">
        </div>
        <div>
            <label class="common_label">Category</label>
            <input id="chooseCategoryBtn" name="chooseCategoryBtn" class="common_btn" type="button" value="Please choose">
       		<input id="hiddenCategoryId" name="hiddenCategoryId" value="0" type="hidden">
        </div>
        <div>
            <div id="seller_categoryList">
                <!-- <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span>
                <span class="seller_categoryListItem">LongLiveKing</span> -->
            </div>
        </div>
        <div style="margin-top: 20px" id="sellerCategoryTag">
            <label class="common_label left">Tag</label>
            <div id="sellerCategoryTagList">
                <!-- <span class="sellerCategoryTagItem" data-state="0">Tag1</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag2</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag3</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag4</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag5</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag1</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag2</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag3</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag4</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag5</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag1</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag2</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag3</span>
                <span class="sellerCategoryTagItem" data-state="0">Tag4</span> -->
            </div>
        </div>
        <div>
            <label class="common_label">Price</label>
            <input class="common_input" type="text" name="price" id="price" placeholder="Price">
            <input class="common_input" type="text" name="promotion" id="promotion" placeholder="Promotion">
        </div>
        <!-- <div>
            <label class="common_label">Contact</label>
            <input class="common_input" type="text" name="sellername" placeholder="Your name">
            <input class="common_input" type="text" name="phonenum" placeholder="Phone Number">
        </div> -->
       <div>
            <label class="common_label left">Image</label>
            <div id="uploadDiv">
                <div id="uploadImages">
                </div>
                <div id="upload">
                    <a href="javascript:void(0)">
                        <img src="images/upload.JPG">
                    </a>
                </div>
                <div id="fileInput" style="display:none">
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
        <div style="margin-left: 90px; margin-top: 30px">
          <input style="width: 80px" class="common_btn" value="Confirm" id="publish_btn">
        </div>
    </form>
</div>











