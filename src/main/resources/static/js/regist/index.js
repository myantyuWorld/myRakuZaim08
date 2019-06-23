$(function(){
    //Default
     $('#datepicker-default .date').datepicker({
         format: "yyyy/mm/dd",
         language: 'ja'
     });
    
	// 記録ボタン押下
	$("button[name='btnInput'").on('click', function() {
		console.log("call");
		
		var data = {
			 money : $("#money").val(),
			 date : $("#date").val(),
			 category : $("input[name='category']:checked").val(),
			 kubn : $("input[name='kubn']:checked").val(),
			 biko : $("#biko").text()
		 }
		// 必須チェック
		if (!checkInput(data)) {
			toastr.error("未入力の項目があります！");
			return;
		}
		ajaxRegistForm(data);
	});
});

// 入力チェックメソッド
function checkInput(data) {
	if (data["money"] == "") {return false;;}
	if (data["date"] == "") {return false;;}
	return true;
}
// 支出オブジェクトを登録するAPIをたたくメソッド
function ajaxRegistForm(data) {
	$.ajax({
	    type: "post",
	    url: location.pathname + "post",  
	    data: data
	}).then(function (result) {
		if (result) {
			toastr.success("登録しました！");
		}
	}, function () {
		toastr.error('Ajaxリクエストに失敗しました。myantyuに相談してね！');
	});
}
