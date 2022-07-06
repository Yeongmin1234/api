var commonMsg = {
    'sale-title-1': {
        en: '1st Auction',
        ja: '第1次オークション',
        zt: '第1次拍賣'
    },
    'sale-term-1': {
        en: '4/19(TUE) 06:00 ~ 4/21(THU) 06:00, UTC',
        ja: '4/19(火) 06:00 ~ 4/21(木) 06:00, UTC',
        zt: '4/19(TUE) 06:00 ~ 4/21(THU) 06:00, UTC'
    },
    'sale-title-2': {
        en: '2nd Auction',
        ja: '第2次オークション',
        zt: '第2次拍賣'
    },
    'sale-term-2': {
        en: '4/22(FRI) 06:00 ~ 4/24(SUN) 06:00, UTC',
        ja: '4/22(金) 06:00 ~ 4/24(日) 06:00, UTC',
        zt: '4/22(FRI) 06:00 ~ 4/24(SUN) 06:00, UTC'
    }
}
var opt = {
    data: commonMsg, // 번안 저장 객체 (translate-key > 언어 > 내용)
    language: 'en', // 번안을 원하는 언어
    cleanDataset: true // [선택 사항] 치환 후 dataset을 제거할 지 여부 (Default. true)
    // target: '.optional', // [선택 사항] 범위 지정을 원할 시 선택자 지정
};
var go = () => {
    GAMEDEX.translate(opt)
        .then(function (result) {
            console.log(result); // 언어 치환 성공 시 언어 치환 갯수 리턴
        })
        .catch(function (err) {
            console.log(err); // 언어 치환 실패 시 에러 코드 리턴
        })
        .finally(function () {
            const HTML = document.querySelector('html');
            const BODY = document.querySelector('body');

            HTML.setAttribute('lang', opt.language);
            BODY.classList.add(opt.language);
            BODY.style.visibility = 'visible';

            if (opt.language === 'ar') {
                HTML.setAttribute('dir', 'rtl');
            }

            console.log('end'); // 성공 실패 여부와 상관 없이 실행
        });
};
window.addEventListener('DOMContentLoaded', function () {
    go();
});