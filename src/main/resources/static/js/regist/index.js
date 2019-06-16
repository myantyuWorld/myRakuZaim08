$(function(){
	
	
    //Default
    $('#datepicker-default .date').datepicker({
        format: "yyyy/mm/dd",
        language: 'ja'
    });
    
	// 記録ボタン押下
	$("#btnInput").on('click', function() {
		
		$form = $("form");
		$.ajax({
	        type: "post",
	        url: location.pathname + "/post",  //Controllerを呼び出すURLになっていればOK
	        data: $("form").serialize()
	      }).then(function (result) {
	        console.log('成功時の処理が書けます。下のように。');
	        let content = result.content;
	      }, function () {
	        console.log('失敗時の処理が書けます');
	      });
	});
});