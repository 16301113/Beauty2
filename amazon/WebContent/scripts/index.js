//上一页方法
function lastPage() {

	var totalPage = $("#totalPage").val()
	var cate = $("#cate").val()
	var pid = $("#pid").val()
	var pageNo = parseInt($("#currentPage").val())
	var name = $("#queryName").val()

	if (name == null) {
		name = 0;
	}

	if (pageNo == 1) {
		alert("已经是第一页了!")
	} else {
		pageNo = pageNo - 1
		window.location.href = "ref?cate=" + cate + "&page=" + pageNo + "&pid="
				+ pid + "&qname=" + name
	}
}

// 下一页方法
function nextPage() {

	var totalPage = $("#totalPage").val()
	var cate = $("#cate").val()
	var pid = $("#pid").val()
	var pageNo = parseInt($("#currentPage").val())
	var name = $("#queryName").val()

	if (name == null) {
		name = 0;
	}

	if (pageNo == parseInt(totalPage)) {
		alert("已经是最后一页了!")
	} else {
		pageNo = pageNo + 1
		window.location.href = "ref?cate=" + cate + "&page=" + pageNo + "&pid="
				+ pid + "&qname=" + name
	}

}

function queryProducts() {
	var qname = $("#qname").val()
	if (qname == null) {
		alert("请输入想要搜索的商品名!")
	} else {
		window.location.href = "index.jsp?qname=" + qname

	}

}
