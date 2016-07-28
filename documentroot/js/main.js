$(function(){
//------------------------------------------------------------------------
//						WOW ANIMATION SETTINGS
//------------------------------------------------------------------------
	var wow = new WOW({
    	offset:200,        // distance to the element when triggering the animation (default is 0)
    	mobile:false       // trigger animations on mobile devices (default is true)
  	});
	wow.init();

    redrawPage();

});

//$(window).load(function() { 
//    $(window).trigger('resize');
//});
$(window).load(function() { 
  $(window).trigger('resize');
});

$(window).scroll(function () {
    if ($(document).height() <= $(window).scrollTop() + $(window).height()) {
        //alert("End Of The Page");
        //console.log("End Of The Page");
        $.getJSON("/controller/?cmd=load-more&category=all&total="+allBooks.length,function(response,status, jqXHR){
            //access value from nested... [][][] ruby on rails ...  httparty gem rubbyy
            //Sting response['Title'];
            //console.log("End Of The Page RESULT");

            drawBooks(response);

            allBooks = allBooks.concat(response);
            //allBooks.push(response);

            $(window).trigger('resize');

            $('.book-image').load(function() { 
                $(window).trigger('resize');
            });
        });

    }
 });

function drawBooks(books){

    var body = '';

    if(topbooks){
        topbooks.forEach(function(book){
            body += '<div class="vertical-container100px">';
            body += '<h3><center><img class="profile-image" src="' + book.ASIN+'" style="" />';
            body += book.ASIN +' Recommendations</center></h3>';
            body += '</div>';
        });
    }

    if(books){
    
    books.forEach(function(recommender){

        body += '<div class="vertical-container100px">';
        body += '<h3><center><img class="profile-image" src="' + recommender.recommenderImageLink+'" style="" />';
        body += recommender.recommenderName +' Recommendations</center></h3>';

        body += '</div>';

        body += '<div id="listing' + recommender.recommenderID +'" class ="grid" >';

        recommender.recommendations.forEach(function(recommendation){

            body += '<div class="box grid-item masonry-brick'+recommender.recommenderID+'" style="">';
            body += '<a href="http://www.amazon.com/dp/' +recommendation.asin +'" target="_blank">';
            body += '<div class="item bluronhover" style="background-image:url(' + recommendation.imageUrl + '); background-size:cover;">';
            body += '<img class="book-image" src="'+ recommendation.imageUrl +'" style="visibility:hidden"/>';
            body += '</div>';

            body += '<div class="displayonhover">';
            body += '<h3><center> '+recommendation.author;
            body += recommendation.title+ '</center></h3>';
            body += '<h4><center>'+ recommendation.review+'</center></h4>';
            body += '</div>';
            body += '</a>';
            body += '</div>';

        });

        body += '</div>';
        body += '</div>';

        $('#listing'+recommender.recommenderID).masonry({
            itemSelector: '.masonry-brick'+recommender.recommenderID,
            isAnimated: true,
            percentPosition: true,
            stamp:'.stamp'
        });
        $('#listing'+recommender.recommenderID).masonry('layout');
    });
    }

    $('.row').append(body);
}

function redrawPage(){

    drawBooks(allBooks);

    allBooks.forEach(function(recommender){
        $('#listing'+recommender.recommenderID).masonry('reloadItems');
        $('#listing'+recommender.recommenderID).masonry('layout');
    });
    $(window).trigger('resize');

}

$(window).on("resize", function () {
    allBooks.forEach(function(recommender){
    $('#listing'+recommender.recommenderID).masonry({
      itemSelector: '.masonry-brick'+recommender.recommenderID,
      isAnimated: true,
      percentPosition: true,
      stamp:'.stamp'
    });
   // $('#listing'+recommender.recommenderID).masonry('layout');
    $('#listing'+recommender.recommenderID).masonry('reloadItems');
    $('#listing'+recommender.recommenderID).masonry('layout');
    });
    
});


$.fn.isOnScreen = function(){

    var win = $(window);

    var viewport = {
        top : win.scrollTop(),
        left : win.scrollLeft()
    };
    viewport.right = viewport.left + win.width();
    viewport.bottom = viewport.top + win.height();

    var bounds = this.offset();
    bounds.right = bounds.left + this.outerWidth();
    bounds.bottom = bounds.top + this.outerHeight();

    return (!(viewport.right<bounds.left || viewport.left > bounds.right || viewport.bottom < bounds.top || viewport.top > bounds.bottom));

};
