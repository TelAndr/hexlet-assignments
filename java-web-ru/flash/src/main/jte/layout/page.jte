<!-- BEGIN -->
@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage bPage = null


<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
@if(bPage != null && bPage.getFlash() != null)
    @if(!bPage.getIsSuccessful())
        <div class="alert alert-danger" role="alert">
            <p>${bPage.getFlash()}</p>
        </div>
    @else
        <div class="alert alert-success" role="alert">
            <p>${bPage.getFlash()}</p>
        </div>
    @endif
@endif
${content}
</body>
</html>
<!-- END -->
