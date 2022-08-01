
app.factory('downloadFactory', function () {
    function DownloadManager() {
    }
    DownloadManager.prototype = {
        getData: function (data, opcion) {
            var file = new Blob([data], {type: 'application/pdf'});
            var fileURL = URL.createObjectURL(file);

            var link = document.createElement('a');
            link.href = fileURL;
            if (opcion== 'descargar'){
            	link.download = "report.pdf";
                link.click();	
                }else {
                	window.open(fileURL);
                    document.getElementById('visualizador').setAttribute('src',fileURL);
                }
        },

    };
    return DownloadManager;
});
