<template>
    <div class="app-container home">
        <el-row :gutter="20">
            <el-col :sm="24" :lg="12" style="padding-left: 20px">
                <h2>智能停车场-后台管理系统</h2>
                <p>
                    当今社会，随着城市化进程的不断推进以及汽车拥有率的迅速增加，停车问题已成为城市交通管理的一项重要挑战。尤其是在城市中心区域，有限的停车资源与不断增长的停车需求之间的矛盾日益突出。传统的停车场管理方式已经难以满足日益复杂的管理需求，这促使了智能停车场管理系统的崭露头角。
                    随着信息技术的快速发展，智能停车场管理系统正在积极应对这一挑战。本系统结合了物联网、图像识别等先进技术，为停车场管理带来了全新的可能性。
                </p>
                <p>
                    <el-button
                        type="primary"
                        size="mini"
                        icon="el-icon-cloudy"
                        plain
                        @click="
                            goTarget(
                                'https://github.com/ChenNan777/smart-parking'
                            )
                        "
                        >Go GitHub</el-button
                    >
                </p>
            </el-col>
        </el-row>
        <el-divider />
        <el-row :gutter="20">
            <el-col :xs="24" :sm="24" :md="12" :lg="8">
                <el-card class="update-log">
                    <div slot="header" class="clearfix">
                        <span>联系信息</span>
                    </div>
                    <div class="body">
                        <p>
                            <i class="el-icon-phone"></i> 联系电话：18559214623
                        </p>
                        <p>
                            <i class="el-icon-chat-dot-round"></i>
                            微信：cn904296448
                        </p>
                        <p><i class="el-icon-money"></i> QQ：905394587</p>
                    </div>
                </el-card>
            </el-col>
            <el-col :xs="24" :sm="24" :md="12" :lg="8">
                <el-card class="update-log">
                    <div slot="header" class="clearfix">
                        <span>更新日志</span>
                    </div>
                    <el-collapse accordion>
                        <el-collapse-item title="v1.0.0 - 2023-11-xx">
                            <ol>
                                <li>智能停车管理系统正式发布</li>
                            </ol>
                        </el-collapse-item>
                    </el-collapse>
                </el-card>
            </el-col>
            <el-col :xs="24" :sm="24" :md="12" :lg="8">
                <el-card class="update-log">
                    <div slot="header" class="clearfix">
                        <span>联系方式</span>
                    </div>
                    <div class="body">
                        <img
                            src="@/assets/images/vx.png"
                            alt="donate"
                            width="100%"
                        />
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
  export default {
      name: 'Index',
      data() {
          return {
              // 版本号
              version: '3.6.3',
          };
      },
      methods: {
          goTarget(href) {
              window.open(href, '_blank');
          },
      },
  };
</script>

<style scoped lang="scss">
  .home {
      blockquote {
          padding: 10px 20px;
          margin: 0 0 20px;
          font-size: 17.5px;
          border-left: 5px solid #eee;
      }
      hr {
          margin-top: 20px;
          margin-bottom: 20px;
          border: 0;
          border-top: 1px solid #eee;
      }
      .col-item {
          margin-bottom: 20px;
      }

      ul {
          padding: 0;
          margin: 0;
      }

      font-family: 'open sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
      font-size: 13px;
      color: #676a6c;
      overflow-x: hidden;

      ul {
          list-style-type: none;
      }

      h4 {
          margin-top: 0px;
      }

      h2 {
          margin-top: 10px;
          font-size: 26px;
          font-weight: 100;
      }

      p {
          margin-top: 10px;

          b {
              font-weight: 700;
          }
      }

      .update-log {
          ol {
              display: block;
              list-style-type: decimal;
              margin-block-start: 1em;
              margin-block-end: 1em;
              margin-inline-start: 0;
              margin-inline-end: 0;
              padding-inline-start: 40px;
          }
      }
  }
</style>
