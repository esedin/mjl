document.addEventListener('DOMContentLoaded', function () {
  document.getElementById('startsearch').addEventListener('click', doSearch);
});

function doSearch() {
  console.log('aaaaa1111');
  var searchterm = document.getElementById('inputf').value;
  var searchUrl = "https://www.google.com.ua/search?q=" + searchterm + " -inurl:(htm|html|php|pls|txt) intitle:index.of “last modified” (mkv|mp4|avi)";
  chrome.tabs.create({url:searchUrl});
}
