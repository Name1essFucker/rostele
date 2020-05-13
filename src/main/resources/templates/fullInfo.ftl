<#import "parts/common.ftl" as c>

<@c.page>

    <h5>${building.title}</h5>

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="/img/${building.filename}" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="/img/${building.filename}" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="/img/${building.filename}" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="form-group row my-3" >
        <label for="title" class="col-sm-2 col-form-label">Title</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="title" value="${building.title}">
        </div>
        <label for="address" class="col-sm-2 col-form-label">Address</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="address" value="${building.address}">
        </div>
        <label for="price" class="col-sm-2 col-form-label">Price</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="price" value="${building.price}&nbsp;рублей">
        </div>
        <label for="category" class="col-sm-2 col-form-label">Category</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="category" value="${building.category}">
        </div>
        <label for="Area" class="col-sm-2 col-form-label">Area</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="Area" value="${building.area}&nbspкв.м">
        </div>
        <label for="buildingDescription" class="col-sm-2 col-form-label">Description</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="buildingDescription" value="${building.description}">
        </div>
        <label for="email" class="col-sm-2 col-form-label">E-mail</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="email" value="${building.email!'•'}">
        </div>
        <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="phoneNumber" value="${building.phoneNumber!'•'}">
        </div>
        <label for="buildingAuthor" class="col-sm-2 col-form-label">Author</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="buildingAuthor" value="${building.authorName}">
        </div>
    </div>
</@c.page>