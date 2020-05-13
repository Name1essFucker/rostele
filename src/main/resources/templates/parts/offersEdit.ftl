<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
         Add or edit offer
</a>
<div class="collapse <#if building??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(titleError??)?string('is-invalid', '')}"
                       value="<#if building??>${building.title}</#if>" name="title" placeholder="Title" />
                <#if titleError??>
                    <div class="invalid-feedback">
                        ${titleError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.address}</#if>" name="address" placeholder="Address">
                <#if addressError??>
                    <div class="invalid-feedback">
                        ${addressError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.price}</#if>" name="price" placeholder="Price(RUB)">
                <#if priceError??>
                    <div class="invalid-feedback">
                        ${priceError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.category}</#if>" name="category" placeholder="Category">
                <#if categoryError??>
                    <div class="invalid-feedback">
                        ${categoryError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.area}</#if>" name="area" placeholder="Area (Square kilometer)">
                <#if areaError??>
                    <div class="invalid-feedback">
                        ${areaError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.description}</#if>" name="description" placeholder="Description">
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.email}</#if>" name="email" placeholder="E-mail">
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if building??>${building.phoneNumber}</#if>" name="phoneNumber" placeholder="Phone number">
                <#if phoneNumberError??>
                    <div class="invalid-feedback">
                        ${phoneNumberError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="<#if building??>${building.id}<#else>-1</#if>"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>
    </div>
</div>
