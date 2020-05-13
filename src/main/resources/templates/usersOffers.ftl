<#import "parts/common.ftl" as c>

<@c.page>
    <#if isCurrentUser>
        <#include "parts/offersEdit.ftl" />
    </#if>

    <#include "parts/offersList.ftl" />
</@c.page>