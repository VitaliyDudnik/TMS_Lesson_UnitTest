
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegUserContent</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="d-flex align-items-center mt-5 mb-2  text-muted author-info ">
                <a class="d-flex align-items-center text-muted text-decoration-none" href="https://github.com/VitaliyDudnik" target="_blank" rel="noopener">
                    <img class="mb-0 mr-2" style="border-radius: 10px" srcset="https://avatars.githubusercontent.com/u/82210074?s=100&amp;v=4" src="https://avatars.githubusercontent.com/u/82210074?s=100&amp;v=4" alt=""
                         width="40" height="40">
                    <span>@V.Dudnik</span>
                </a>
            </div>
            <div class="card  mb-2 border-0">
                <img src="https://www.designquote.net/wp/wp-content/uploads/2018/08/backend-vs-frontend.png" style="border-radius: 7px" alt="...">
                <div class="card-body">
                    <div class="row justify-content-center">
                        <div class="offset-mx-4">
                            <h6><span class="badge bg-secondary"><i class="bi bi-plus-lg"></i>New</span>
                                <button class="btn btn-block btn-info col-sm-3 offset-md-9" style="border-radius:30px; height: 30px; width: 70px; color: floralwhite; font-size:12px"><i class="fa fa-thumbs-up">Like</i> </button>
                            </h6>

                        </div>
                        <div class="col-sm-12">
                            <h5 class="card-title" style="font-style: italic">Everything you need to know about programming</h5>
                        </div>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-info  w-100" style="color: floralwhite">Read</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="accordion accordion-flush col-3 mt-5 mb-2  " id="accordionFlushExample">
            <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingOne">
                    <div class="row">
                        <div class="w-100">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                              Username
                            </button>
                        </div>
                    </div>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingTwo">

                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        Username
                    </button>
                    <i class="bi bi-person-square"></i>
                </h2>
                <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being filled with some actual content.</div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingThree">
                    <button class="accordion-button " type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                        Username
                    </button>
                    <i class="bi bi-person-square"></i>
                </h2>
                <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the third item's accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.</div>
                </div>
                <div class="mb-3 mt-2">
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" style="margin-top: 0px; margin-bottom: 0px; height: 50px;"></textarea>
                    <button type="button" class="bg-white w-100 border-0" style="font-style: italic;"><strong>Comment</strong></button>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
