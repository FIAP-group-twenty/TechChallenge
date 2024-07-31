import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
//    http.get('http://localhost:30005/api/v1/swagger-ui/index.html');
    http.get('http://ec2-54-89-159-124.compute-1.amazonaws.com:30005/api/v1/swagger-ui/index.html');
    sleep(1);
}
