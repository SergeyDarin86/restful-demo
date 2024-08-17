'use strict';
(function ($) {

        indexPage: {
            address: '/API',
            type: 'POST',
            action: function(result, $this){
                if (result.result){
                    if ($this.next('.API-error').length) {
                        $this.next('.API-error').remove();
                    }
                    if ($this.next('.API-success').length) {
                        $this.next('.API-success').text('Страница добавлена/обновлена успешно');
                    } else {
                        $this.after('<div class="API-success">Страница поставлена в очередь на обновление / добавление</div>');
                    }
                } else {
                    if ($this.next('.API-success').length) {
                        $this.next('.API-success').remove();
                    }
                    if ($this.next('.API-error').length) {
                        $this.next('.API-error').text(result.error);
                    } else {
                        $this.after('<div class="API-error">' + result.error + '</div>');
                    }
                }
            }
        }

});


})(jQuery);