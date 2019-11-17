$(function() {
	var url = location.href;
	
	$("#btnCategoryImport").on('click', function(){
		categoryImport(url);
	});
	
});
/***
 * 楽天レシピのカテゴリをIMPORTする
 * @param url URL
 * @returns カテゴリIMPORTした処理結果
 */
function categoryImport(url) {
	console.log(url);
	$.ajax({
        url: url + '/categoryImport',
        type:'GET'
    })
    // Ajaxリクエストが成功した時発動
    .done( (data) => {
    	toastr.success('処理成功')
    })
    // Ajaxリクエストが失敗した時発動
    .fail( (data) => {
    	toastr.error('Ajaxリクエストに失敗しました。myantyuに相談してね！');
    })
}

