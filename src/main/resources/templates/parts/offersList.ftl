<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />

<div class="card-columns">
    <#list page.content as building>
        <div class="card my-3">
            <#if building.filename??>
                <img src="/img/${building.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${building.title}</span><br/>
                <i>${building.category}</i>
            </div>
            <div class="card-footer text-muted">
                <a href ="/users-offers/${building.author.id}">${building.authorName}</a>
                <#if building.author.id == currentUserId>
                    <a class="btn btn-secondary" href ="/users-offers/${building.author.id}?building=${building.id}">
                        Edit
                    </a>
                    <a class="btn btn-danger" href ="/building/delete/${building.id}">
                        Delete
                    </a>
                </#if>
                <a class="btn btn-secondary my-2" href="/fullInfo/${building.id}">Full info</a>
            </div>
        </div>
    <#else>
        There is nothing to show
    </#list>
</div>
<@p.pager url page />