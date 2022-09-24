
export const BASE_URL = 'http://localhost:9090';
/**
 * Fetch를 통해 http 전송을 보냅니다
 * @param {string} url - 전송 주소
 * @param {string} method  - HTTP 메소드
 * @param {Object} param - body에 담길 파라미터
 * @returns 
 */
export const fetchJson = async (url, method, param ) => {
    const opt = {
        method: method,
        headers: {
        'Content-Type': 'application/json',
        'X-XSRF-TOKEN': await getCsrfToken(),
        },
        body: JSON.stringify(param)
    }
    return fetch(url, opt);
}

/**
 * 
 * @returns {string} csrfToken - 브라우저의 Cookkie에 저장된 csrf 토큰을 리턴합니다.
 */
const getCsrfToken = async () => {
    try{
        const csrfToken = document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`))[1];
        return csrfToken;
    } catch(e) {
        await fetchJson('/');
        const csrfToken = document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`))[1];
        return csrfToken;
    }
}