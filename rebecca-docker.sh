#!/bin/sh

# 获取脚本所在的目录
SCRIPT_DIR="$(dirname "$(realpath "$0")")"
echo "$SCRIPT_DIR"

# 切换到脚本所在的目录
cd "$SCRIPT_DIR" || { echo "无法切换到目录 $SCRIPT_DIR"; exit 1; }
echo "切换到工作目录 $SCRIPT_DIR"
echo '
________     ______
___  __ \_______  /________________________ _
__  /_/ /  _ \_  __ \  _ \  ___/  ___/  __ `/
_  _, _//  __/  /_/ /  __/ /__ / /__ / /_/ /
 /_/ |_| \___//_.___/\___/\___/ \___/ \__,_/
'

# 定义.env文件名
ENV_FILE=".env"
PRESET_CONFIG="
# Mysql配置
MYSQL_LOCAL_PORT=3306
MYSQL_ROOT_PASSWORD=root
TZ=Asia/Shanghai

# Redis配置
REDIS_LOCAL_PORT=6379
REDIS_PASSWORD=redis
"

# 检查并处理环境参数
case "$1" in
    dev)
        ENV_FILE=".env.dev"
        ;;
    prod)
        ENV_FILE=".env.prod"
        ;;
    *)
        echo "未指定环境参数，使用默认配置。"
        ;;
esac

# 检查.env文件是否存在，如果不存在则创建并写入预设配置
if [ ! -f "$ENV_FILE" ]; then
    echo "$ENV_FILE 文件不存在"
    echo "没有配置文件也敢起项目是吧，看我不狠狠的写入你"
    echo -e "$PRESET_CONFIG" > "$ENV_FILE"
    echo "默认配置："
    echo "$PRESET_CONFIG"
fi

# 加载环境变量
#set -o allexport
#source "$ENV_FILE"
#set +o allexport

# 启动Docker Compose
#docker-compose up
