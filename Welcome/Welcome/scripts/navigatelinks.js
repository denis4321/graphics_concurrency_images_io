function navigateLinks(direction) {
    var topic = new Array(
        "welcome_first.html",
        "welcome_UI.html",
        "welcome_newproject.html",
        "welcome_editing.html",
        "welcome_designing.html",
        "welcome_compiling_running.html",
        "welcome_advancedbuild.html",
        "welcome_uml.html",
        "welcome_refactoring.html",
        "welcome_debugging.html",
        "welcome_unittesting.html",
        "welcome_optimize.html",
        "welcome_deploy.html",
        "welcome_javadoc.html",
        "welcome_team.html",
        "welcome_database.html",
        "welcome_webx.html",
        "welcome_ejb.html",
        "welcome_xml.html",
        "welcome_websvcs.html",
        "welcome_mobile.html",
        "welcome_opentools.html",
        "welcome_help.html",
        "welcome_whatsnext.html"
    );

    
    lastDelimiter = parent.contentWin.document.location.pathname.lastIndexOf("/");
    currentTopic = parent.contentWin.document.location.pathname.substring(lastDelimiter+1, parent.contentWin.document.location.pathname.length);
    
    for (checkTopic in topic) {
      if (topic[checkTopic] == currentTopic)
        break;
    }
    

    if (direction == 1)
        checkTopic++;
    else
        checkTopic--;

    if (checkTopic < 0)
        checkTopic = 0;
        
    if (checkTopic > (topic.length-1))
        checkTopic = topic.length-1;

    parent.contentWin.location = topic[checkTopic];
}
