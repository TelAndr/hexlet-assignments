@import gg.jte.Content

@param Content header
@param Content footer
@param Content content

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="with=device-with, initial-scale=1">
    <title>Макет сайта</title>
</head>
<body>
    <header>
        <h1>${header}</h1>
    </header>
    <h1>User</h1>
    <div class="content">
        ${content}
    </div>
    @if (footer != null)
        <div class="footer">
            ${footer}
        </div>
    @endif
</body>