<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h5>Служба технической поддержки</h5>
    <div>Если у вас возник вопрос или появилась какая-либо проблема Вы можете обратиться к нам!</div>
    <br>
    <div>Мы постараемся как можно скорее решить вашу проблему!</div>
    <br>
    <div>
        <form method="post" enctype="multipart/form-data">
            <div class="form-group mt-3">
                <input type="text" class="form-control" name="text" placeholder="Enter your question" />
            </div>
            <div class="form-group mt-3">
                <input type="email" class="form-control" name="email" placeholder="Enter your e-mail" />
            </div>
            <div class="form-group mt-3">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group mt-3">
                    <button type="submit" class="btn btn-primary">Send</button>
                </div>
    </div>
    </form>
</@c.page>
