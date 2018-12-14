//全选或者全不 选

$(document).ready(function() {

	$("#allcheck").click(function() {
		if ($(this).prop("checked")) {
			$('input[name="onecheck"]').prop("checked", true);
		} else {
			$('input[name="onecheck"]').prop("checked", false);
		}
	});
	// or
	var isChecked = $(this).prop("checked");
	$("input[name='onecheck']").prop("checked", isChecked);

});

function oneclick() {
	// 当没有选中某个子复选框时，SelectAll取消选中
	if (!$("#onecheck").checked) {
		$("#allcheck").prop("checked", false);
	}
	var chsub = $("input[type='checkbox'][name='onecheck']").length; // 获取subcheck的个数
	var checkedsub = $("input[type='checkbox'][name='onecheck']:checked").length; // 获取选中的subcheck的个数
	if (checkedsub == chsub) {
		$("#allcheck").prop("checked", true);
	}
}


function deleteCart(cid) {

	$.ajax({
		url : "deleteCart",// 请求的servlet地址
		type : "GET",// 请求方式
		data : "" + cid,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function() {

		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

function alterCount(cid) {

	// window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	$.ajax({
		url : "alterQuantity",// 请求的servlet地址
		type : "GET",// 请求方式
		data : "pidcounts=" + cid + "_" + $("#count" + cid).val(),// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			$("#count" + cid).val(total);
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

// -按钮事件
function reduce(id) {

	if ($("#count" + id).val() == 1) {
		$("#count" + id).val(1)
	} else if ($("#count" + id).val() >= 2) {
		var old = $("#count" + id).val()
		$("#count" + id).val(parseInt(old) - 1)
	}
	alterCount(id)
}

// +按钮事件
function increase(id) {

	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#count" + id).val()// 获得原来的数量
	if (parseInt(old) < parseInt(stock)) {
		$("#count" + id).val(parseInt(old) + 1)
		alterCount(id)
	} else {
		alert("您选择的数量超过库存!")
	}

}

function checkStock(id) {
	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#count" + id).val()// 获得原来的数量
	if (parseInt(old) > parseInt(stock)) {
		alert("您选择的数量超过库存!")
	} else {
		alterCount(id)
	}
}

function buttonTest(id) {
	alert("测试id=" + id)
}
