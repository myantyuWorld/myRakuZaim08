$(function() {
	
	var url = location.href;
	console.log(url);
	// nichiyou
	
	
	// foodストを
	$("#btnFood").on('click', function() {
		$form = $("#memoForm");
		$.ajax({
            url: url + '/post',
            type:'POST',
            data: {
            	mmnm : $("#mmnmFood").val(),
            	mmsb : 2
            }
        })
        // Ajaxリクエストが成功した時発動
        .done( (data) => {
        	allInitInput();
        	appendFood(data);
        	toastr.info('テストを登録しました！.');
        })
        // Ajaxリクエストが失敗した時発動
        .fail( (data) => {
        	allInitInput();
        	toastr.info('登録に失敗しました。');
        })
	});
});

function allInitInput() {
	$("#mmnmFood").val("");
	$("#mmnmNichiyou").val("");
}

function appendFood(data){
//	card-block
	$(".card-block").append('<div class="' + data["mmid"] + '"><p class="card-footer"><span class="left">' + data["mmnm"] + '</span> <span class="right"><buttonid="btn-food-1" name="btn-food"class="btn btn-outline-info btn-sm">X</button></span></p></div>')
}

