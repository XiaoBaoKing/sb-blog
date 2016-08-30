function ajax(type, _url, message) {
	var httpxml = new XMLHttpRequest();
	if(type == 'get') {
		httpxml.(type, _url, true);
		if(httpxml.onreadystatechange == 4) {
			if(httpxml.status == 200) {
				return httpxml.responseText;
			}
		} else {
			return document.innerHTML = ('<span>请求失败</span>');
		}
	} else if(type == 'post') {
		httpxml(type, _url, true);
		httpxml.send(message)
		if(httpxml.onreadystatechange == 4) {
			if(httpxml.status == 200) {
				return httpxml.responseText;
			} else {
				return document.innerHTML = ('<span>请求失败</span>');
			}
		}
	}