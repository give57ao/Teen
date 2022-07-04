function autoSizePopup()
{
    var winResizeW=0;
    var winResizeH=0;
   
    $(document).ready(function() {
        //크롬, 사파리일때
        if (navigator.userAgent.indexOf('Chrome')>-1 || navigator.userAgent.indexOf('Safari')>-1)
        {
            $(window).resize(function() {
               
                if(winResizeW==0 && winResizeH==0)
                {
                    resizeWin();
                }
            });
        }
        //크롬, 사파리말고 모두
        else
        {
            resizeWin();
        }
    });
   
    function resizeWin()
    {
        var conW = $(".popup_wrap").innerWidth(); //컨텐트 사이즈
        var conH = $(".popup_wrap").innerHeight();
   
        var winOuterW = window.outerWidth; //브라우저 전체 사이즈
        var winOuterH = window.outerHeight;
       
        var winInnerW = window.innerWidth; //스크롤 포함한 body영역
        var winInnerH = window.innerHeight;
       
        var winOffSetW = window.document.body.offsetWidth; //스크롤 제외한 body영역
        var winOffSetH = window.document.body.offsetHeight;
       
        var borderW = winOuterW - winInnerW;
        var borderH = winOuterH - winInnerH;
       
        //var scrollW = winInnerW - winOffSetW;
        //var scrollH = winInnerH - winOffSetH;
       
        winResizeW = conW + borderW;
        winResizeH = conH + borderH;
       
        window.resizeTo(winResizeW,winResizeH);
    }
}