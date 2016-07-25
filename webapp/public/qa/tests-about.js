suite('"About" Page Tests', function () {
    test('page show contain link to contact page',function () {
        assert($('a[href="/contact"]').length);
    });
});