<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="message" placeholder="Введите сообщение" />
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Найти</button>
    </form>
    <#list techsupports as techsupport>
        <div>
            <b>${techsupport.id}</b>
            <span>${techsupport.message}</span>
            <strong>${techsupport.authorName}</strong>
            <div>
                <#if techsupport.filename??>
                    <img src="/img/${techsupport.filename}">
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</@c.page>