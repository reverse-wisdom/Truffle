// 프론트만 우선적 처리
// 젠킨스 파이프라인 플러그인을 호출하기 위한 블록
pipeline {
    // 파이프라인을 실행하고 싶은 위치 정의
    agent none
    // gitlab의 소스를 jenkins 디렉토리로 내려받을 시
    // skipDefaultCheckout(true)일 경우 내려받는 프로세스 skip
    // skipDefaultCheckout(false)일 경우 gitlab 소스 체크
    options { skipDefaultCheckout(false) }
    // stage의 모음
    stages {
        stage('Docker build') {
            agent any
            steps {
                // front-end 및 back-end dockerfile 실행을 통해 image 생성
                // -t : 이미지 이름과 tag 설정, 만약 이미지 이름만 설정하면 latest로 설정됨
                sh 'docker build -t base-pjt-front:latest ./frontend/truffle/'
                // sh 'docker build -t <back-image-name>:latest <back dockerfile path>'
            }
        }
        stage('Docker run') {
        agent any
            steps {
                // 현재 동작중인 컨테이너 중 <front-image-name>의 이름을 가진 컨테이너를 stop
                sh 'docker ps -f name=base-pjt-front -q \
                | xargs --no-run-if-empty docker container stop'
                // 현재 동작중인 컨테이너 중 <back-image-name>의 이름을 가진 컨테이너를 stop
                // sh 'docker ps -f name=<back-image-name> -q \
                // | xargs --no-run-if-empty docker container stop'
                // <front-image-name>의 이름을 가진 컨테이너를 삭제
                sh 'docker container ls -a -f name=base-pjt-front -q \
                | xargs -r docker container rm'
                // <back-image-name>의 이름을 가진 컨테이너를 삭제
                // sh 'docker container ls -a -f name=<back-image-name> -q \
                // | xargs -r docker container rm'
                // docker image build 시 기존에 존재하던 이미지는
                // dangling 상태가 되기 때문에 이미지를 일괄 삭제
                sh 'docker images -f dangling=true && \
                docker rmi $(docker images -f "dangling=true" -q)'
                // docker container 실행
                // 하나의 docker network에 연결하여 통신이 가능하도록 설정
                sh 'docker run -d --name base-pjt-front \
                -p 80:80 \
                -p 443:443 \
                -v /home/ubuntu/keys/:/var/jenkins_home/workspace/truffle_deploy/keys/ \
                --network truffleProxy \
                base-pjt-front:latest'
                // sh 'docker run -d --name <back-image-name> \
                // --network <만들어둔 docker network 이름> \
                // <back-image-name>:latest'
            }
        }
    }
}
