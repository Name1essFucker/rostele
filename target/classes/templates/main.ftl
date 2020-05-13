<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="from-inline">
                <input type="text" name="filter" value="${filter!}" placeholder="Search">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <#include "parts/offersEdit.ftl" />
    <#include "parts/offersList.ftl" />
</@c.page>