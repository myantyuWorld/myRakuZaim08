$(function() {
	const MMSB_NITIYOU = 1;
	const MMSB_FOOD = 2;
	
	var url = location.href;
	$("#btnNishityou").on('click', function() {
		if(!checkInput($("#mmnmNitiyou"))) {
			toastr.error("入力してください！");
			return;
		}
		ajaxPost($("#mmnmNitiyou").val(), url,MMSB_NITIYOU);
	});
	$("#btnFood").on('click', function() {
		if(!checkInput($("#mmnmFood"))) {
			toastr.error("入力してください！");
			return;
		}
		ajaxPost($("#mmnmFood").val(), url,MMSB_FOOD);
	});
	// 「×」ボタン押下時イベント
	$(document).on('click',".btn, .btn-outline-info, .btn-sm", function() {
		var _mmid = $(this).data('mmid');
		var _name = $(this).attr("name");
		
		if ($(this).data('mmid') != null){
			ajaxDelete(url, _mmid, _name);
		}
	});
	// 入力頻度の多いメモ内容を取得し、メモテキストにplaceholderとして配置する
	initPlaceHolderMemo();
});

// メモ画面共通のクリアメソッド
function allInitInput() {
	$("#mmnmFood").val("");
	$("#mmnmFood").css("background-color", "#ffffff");
	$("#mmnmNitiyou").val("");
	$("#mmnmNitiyou").css("background-color", "#ffffff");
}
// メモ共通の入力チェックメソッド
function checkInput(data) {
	if (data.val() == ""){
		data.css("background-color", "yellow");
		return false;
	}
	return true;
	
}
// 「食費」 要素追加メソッド
function appendFood(data){
//	card-block
	$('#card-food').append('<div id=card-food-' + data["mmid"] + '><p class="card-footer"><span class="left">' + data["mmnm"] + '</span> <span class="right"><button id="btn-food" name="card-food" class="btn btn-outline-info btn-sm waves-effect waves-light" data-mmid=' + data['mmid'] + '>X</button></span></p></div>')
}
//「日用品」 要素追加メソッド
function appendNitiyou(data){
//	card-block
	$('#card-nitiyou').append('<div id=card-nitiyou-' + data["mmid"] + '><p class="card-footer"><span class="left">' + data["mmnm"] + '</span> <span class="right"><button id="btn-food" name="card-nitiyou" class="btn btn-outline-info btn-sm waves-effect waves-light" data-mmid=' + data['mmid'] +  '>X</button></span></p></div>')
}
// メモを登録するAPIをたたく
function ajaxPost(data, url, _mmsb) {
	$.ajax({
        url: url + '/post',
        type:'POST',
        data: {
        	mmnm : data,
        	mmsb : _mmsb
        }
    })
    // Ajaxリクエストが成功した時発動
    .done( (data) => {
    	if (data != ""){
        	allInitInput();
        	if (_mmsb == 2) {
        		appendFood(data);
        	} else {
        		appendNitiyou(data);
        	}
        	
        	toastr.success('データを登録しました！.');
    	} else {
    		allInitInput();
        	toastr.error('登録に失敗しました。');
    	}
    })
    // Ajaxリクエストが失敗した時発動
    .fail( (data) => {
    	allInitInput();
    	toastr.error('Ajaxリクエストに失敗しました。myantyuに相談してね！');
    })
}
// メモを削除するAPIをたたく
function ajaxDelete(url, _mmid, _name){
	$.ajax({
        url: url + '/delete',
        type:'POST',
        data: {
        	mmid : _mmid
        }
    })
    // Ajaxリクエストが成功した時発動
    .done( (data) => {
    	if (data > 0){
    		toastr.success('削除しました！');
    		console.log(_name + "-" + _mmid);
    		$("#" + _name + "-" + _mmid).remove();
    	} else {
        	toastr.error('削除に失敗しました！');
    	}
    })
    // Ajaxリクエストが失敗した時発動
    .fail( (data) => {
    	toastr.error('Ajaxリクエストに失敗しました。myantyuに相談してね！');
    })
}

function initPlaceHolderMemo(){
	$.ajax({
        url: ,
        type:'GET'
    })
    // Ajaxリクエストが成功した時発動
    .done( (data) => {
    	if (data > 0){
    	} 
    })
    // Ajaxリクエストが失敗した時発動
    .fail( (data) => {
    	toastr.error('Ajaxリクエストに失敗しました。myantyuに相談してね！');
    })
}


