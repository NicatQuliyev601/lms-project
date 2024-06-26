import React from 'react';
import './TeacherPage.css'; // Import the CSS file

const calendarIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        strokeWidth="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem]"
        height="3em"
        width="3em"
        xmlns="http://www.w3.org/2000/svg"
    >
        <rect
            width="416"
            height="384"
            x="48"
            y="80"
            fill="none"
            strokeLinejoin="round"
            strokeWidth="32"
            rx="48"
        ></rect>
        <circle cx="296" cy="232" r="24"></circle>
        <circle cx="376" cy="232" r="24"></circle>
        <circle cx="296" cy="312" r="24"></circle>
        <circle cx="376" cy="312" r="24"></circle>
        <circle cx="136" cy="312" r="24"></circle>
        <circle cx="216" cy="312" r="24"></circle>
        <circle cx="136" cy="392" r="24"></circle>
        <circle cx="216" cy="392" r="24"></circle>
        <circle cx="296" cy="392" r="24"></circle>
        <path
            fill="none"
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth="32"
            d="M128 48v32m256-32v32"
        ></path>
        <path
            fill="none"
            strokeLinejoin="round"
            strokeWidth="32"
            d="M464 160H48"
        ></path>
    </svg>
);

const materialIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        stroke-width="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem] "
        height="3em"
        width="3em"
        xmlns="http://www.w3.org/2000/svg">
        <path
            d="M169 57v430h78V57h-78zM25 105v190h46V105H25zm158 23h18v320h-18V128zm128.725 7.69l-45.276 8.124 61.825 344.497 45.276-8.124-61.825-344.497zM89 153v270h62V153H89zm281.502 28.68l-27.594 11.773 5.494 12.877 27.594-11.773-5.494-12.877zm12.56 29.433l-27.597 11.772 5.494 12.877 27.593-11.772-5.492-12.877zm12.555 29.434l-27.594 11.77 99.674 233.628 27.594-11.773-99.673-233.625zM25 313v30h46v-30H25zm190 7h18v128h-18V320zM25 361v126h46V361H25zm64 80v46h62v-46H89z">
        </path>
    </svg>
);

const assignmentIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        strokeWidth="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem]"
        height="3em"
        width="3em"
        xmlns="http://www.w3.org/2000/svg"
    >
        <g>
            <path d="M362.965,21.384H289.62L286.638,7.99C285.614,3.323,281.467,0,276.685,0h-82.618c-4.782,0-8.913,3.323-9.953,7.99
		l-2.967,13.394h-73.36c-26.835,0-48.654,21.827-48.654,48.662v352.06c0,26.835,21.819,48.662,48.654,48.662h255.179
		c26.835,0,48.67-21.827,48.67-48.662V70.046C411.635,43.211,389.8,21.384,362.965,21.384z M379.831,422.105
		c0,9.295-7.563,16.858-16.866,16.858H107.786c-9.287,0-16.85-7.563-16.85-16.858V70.046c0-9.295,7.563-16.857,16.85-16.857h66.294
		l-1.692,7.609c-0.684,3.02,0.062,6.188,1.988,8.596c1.94,2.415,4.876,3.82,7.965,3.82h106.082c3.091,0,6.026-1.405,7.951-3.82
		c1.942-2.415,2.687-5.575,2.004-8.596l-1.692-7.609h66.279c9.303,0,16.866,7.563,16.866,16.857V422.105z"/>
            <path d="M170.835,188.426h43.249l-10.279-7.019c-14.506-9.899-18.232-29.693-8.325-44.197c9.893-14.489,29.693-18.239,44.197-8.324
		l1.694,1.157v-12.136c0-7.866-6.383-14.248-14.242-14.248h-56.294c-7.857,0-14.24,6.383-14.24,14.248v56.271
		C156.595,182.045,162.978,188.426,170.835,188.426z"/>
            <path d="M303.256,110.313l-49.85,47.194l-22.704-15.49c-7.221-4.962-17.13-3.083-22.099,4.162
		c-4.954,7.251-3.09,17.144,4.178,22.098l33.28,22.727c2.718,1.864,5.839,2.772,8.961,2.772c3.96,0,7.888-1.474,10.933-4.356
		l59.167-56.014c6.382-6.033,6.645-16.104,0.62-22.479C319.686,104.552,309.637,104.28,303.256,110.313z"/>
            <path d="M170.835,297.669H214.1l-10.295-7.027c-14.506-9.901-18.232-29.693-8.325-44.197c9.893-14.498,29.693-18.248,44.197-8.325
		l1.694,1.158v-12.136c0-7.865-6.383-14.248-14.242-14.248h-56.294c-7.857,0-14.24,6.383-14.24,14.248v56.279
		C156.595,291.286,162.978,297.669,170.835,297.669z"/>
            <path d="M303.256,219.555l-49.85,47.186l-22.704-15.49c-7.221-4.97-17.13-3.098-22.099,4.162
		c-4.954,7.253-3.09,17.144,4.178,22.099l33.28,22.727c2.718,1.864,5.839,2.772,8.961,2.772c3.96,0,7.888-1.476,10.933-4.356
		l59.167-56.007c6.382-6.033,6.645-16.096,0.62-22.479C319.686,213.793,309.637,213.529,303.256,219.555z"/>
            <path d="M227.129,322.135h-56.294c-7.857,0-14.24,6.383-14.24,14.248v56.271c0,7.865,6.383,14.248,14.24,14.248h56.294
		c7.859,0,14.242-6.383,14.242-14.248v-56.271C241.371,328.518,234.988,322.135,227.129,322.135z"/>
        </g>
    </svg>
)

const groupIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        strokeWidth="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem]"
        height="3.3em"
        width="3.3em"
        xmlns="http://www.w3.org/2000/svg"
    >
        <g>
            <g>
                <g>
                    <path d="M151.549,145.274c0,23.39,9.145,50.385,24.462,72.214c17.389,24.78,39.376,38.427,61.911,38.427
				c22.534,0,44.521-13.647,61.91-38.428c15.317-21.828,24.462-48.824,24.462-72.213c0-47.626-38.746-86.372-86.372-86.372
				C190.296,58.902,151.549,97.648,151.549,145.274z M237.922,73.902c39.354,0,71.372,32.018,71.372,71.372
				c0,20.118-8.33,44.487-21.74,63.598c-14.29,20.364-32.38,32.043-49.632,32.043c-17.252,0-35.342-11.679-49.632-32.043
				c-13.41-19.11-21.741-43.479-21.741-63.598C166.549,105.919,198.567,73.902,237.922,73.902z"/>
                    <path d="M302.372,239.167c-2.862-1.363-6.273-0.778-8.52,1.461c-16.775,16.728-36.117,25.569-55.935,25.569
				c-19.821,0-39.158-8.841-55.923-25.567c-2.246-2.241-5.659-2.826-8.521-1.463c-25.254,12.022-46.628,30.829-61.811,54.388
				c-15.596,24.2-23.84,52.277-23.84,81.195v0.121c0,2.116,0.894,4.134,2.461,5.556c40.492,36.722,92.922,56.945,147.633,56.945
				s107.141-20.224,147.632-56.945c1.568-1.422,2.462-3.439,2.462-5.556v-0.121c0-28.918-8.242-56.995-23.834-81.194
				C348.997,269.995,327.625,251.188,302.372,239.167z M237.918,422.372c-49.861,0-97.685-18.023-135.057-50.827
				c0.583-24.896,7.956-48.986,21.411-69.865c12.741-19.77,30.322-35.823,51.058-46.676c18.746,17.157,40.285,26.193,62.588,26.193
				c22.3,0,43.842-9.035,62.598-26.193c20.734,10.853,38.313,26.906,51.053,46.676c13.452,20.877,20.823,44.968,21.406,69.865
				C335.602,404.349,287.778,422.372,237.918,422.372z"/>
                    <path d="M455.077,243.89c-13.23-20.532-31.856-36.923-53.864-47.399c-2.862-1.363-6.275-0.778-8.52,1.461
				c-14.312,14.271-30.79,21.815-47.654,21.815c-9.142,0-18.184-2.205-26.873-6.553c-3.706-1.853-8.209-0.353-10.063,3.351
				c-1.854,3.705-0.354,8.21,3.351,10.063c10.793,5.401,22.093,8.139,33.586,8.139c19.335,0,38.004-7.737,54.288-22.437
				c17.504,9.298,32.348,22.934,43.141,39.685c11.445,17.763,17.756,38.243,18.338,59.416
				c-18.524,16.158-40.553,28.449-63.91,35.634c-3.959,1.218-6.182,5.415-4.964,9.374c0.992,3.225,3.96,5.297,7.166,5.297
				c0.73,0,1.474-0.107,2.208-0.333c26.509-8.154,51.435-22.362,72.082-41.088c1.568-1.422,2.462-3.439,2.462-5.556v-0.105
				C475.85,289.45,468.666,264.98,455.077,243.89z"/>
                    <path d="M130.493,210.473c7.93,0,15.841-1.934,23.516-5.748c3.709-1.843,5.222-6.345,3.379-10.054
				c-1.843-3.71-6.345-5.222-10.054-3.379c-5.582,2.774-11.248,4.18-16.841,4.18c-14.541,0-29.836-9.914-41.964-27.2
				c-11.449-16.318-18.562-37.112-18.562-54.266c0-33.375,27.152-60.527,60.526-60.527c15.752,0,30.67,6.022,42.006,16.958
				c2.98,2.875,7.729,2.792,10.604-0.19c2.876-2.981,2.791-7.729-0.19-10.604c-14.146-13.647-32.763-21.163-52.42-21.163
				c-41.646,0-75.526,33.881-75.526,75.527c0,20.38,7.957,43.887,21.283,62.881C91.445,198.545,110.709,210.473,130.493,210.473z"/>
                    <path d="M61.034,340.143c-16.753-7.222-32.209-16.972-45.989-29.004c0.582-21.112,6.875-41.53,18.291-59.243
				c10.761-16.698,25.561-30.294,43.01-39.566c16.239,14.662,34.856,22.376,54.139,22.376c11.587,0,22.969-2.785,33.829-8.277
				c3.696-1.87,5.177-6.381,3.308-10.078c-1.869-3.697-6.381-5.177-10.078-3.308c-8.742,4.421-17.846,6.663-27.059,6.663
				c-16.811,0-33.238-7.522-47.504-21.754c-2.246-2.24-5.658-2.825-8.521-1.462c-21.954,10.451-40.534,26.8-53.733,47.28
				C7.167,264.811,0,289.221,0,314.362v0.103c0,2.116,0.894,4.134,2.461,5.556c15.629,14.174,33.338,25.579,52.634,33.897
				c0.968,0.417,1.975,0.615,2.966,0.615c2.904,0,5.668-1.697,6.891-4.533C66.591,346.196,64.837,341.783,61.034,340.143z"/>
                    <path d="M69.854,351.003c-2.671,6.443,4.532,12.832,10.617,9.387c3.238-1.834,4.683-5.937,3.227-9.385
				C81.291,344.86,72.32,345.053,69.854,351.003z"/>
                    <path d="M83.698,351.005C83.888,351.455,83.518,350.545,83.698,351.005L83.698,351.005z"/>
                    <path d="M303.345,70.438c11.336-10.936,26.254-16.958,42.006-16.958c33.374,0,60.526,27.152,60.526,60.527
				c0,17.154-7.112,37.947-18.563,54.266c-12.128,17.286-27.424,27.2-41.964,27.2c-5.593,0-11.259-1.406-16.841-4.18
				c-3.711-1.844-8.212-0.331-10.055,3.379c-1.843,3.709-0.33,8.21,3.379,10.054c7.675,3.814,15.587,5.748,23.517,5.748
				c19.783,0,39.048-11.927,54.243-33.585c13.327-18.994,21.283-42.501,21.283-62.881c0-41.646-33.881-75.527-75.526-75.527
				c-19.657,0-38.273,7.516-52.42,21.163c-2.981,2.875-3.066,7.624-0.19,10.604C295.614,73.229,300.363,73.314,303.345,70.438z"/>
                </g>
            </g>
        </g>
    </svg>
)

const chatIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        strokeWidth="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem]"
        height="25em"
        width="25em"
        xmlns="http://www.w3.org/2000/svg"
    >
        <g>
            <polygon points="35.564,41.136 58,58.467 58,25.663 	"/>
            <path d="M2,25.194v33.47c6.799-5.657,17.051-14.055,22.26-17.672L2,25.194z"/>
            <path
                d="M33.834,42.324c-2.356-1.617-5.588-1.627-7.999,0.01C20.971,45.635,10.513,54.193,3.527,60h53.188L33.834,42.324z"/>
            <path d="M35.665,2.303C34.146,0.817,32.135,0,30,0s-4.146,0.817-5.665,2.303L2.826,23.328L26.17,39.894
		c2.4-1.048,5.171-1.025,7.55,0.085l23.739-16.372L35.665,2.303z M30.708,34.706c-0.092,0.093-0.203,0.166-0.326,0.217
		C30.26,34.974,30.13,35,30,35s-0.26-0.026-0.382-0.077c-0.123-0.051-0.234-0.124-0.326-0.217l-6.999-6.999
		c-0.391-0.391-0.391-1.023,0-1.414s1.023-0.391,1.414,0L29,31.586V15c0-0.553,0.447-1,1-1s1,0.447,1,1v16.586l5.293-5.293
		c0.391-0.391,1.023-0.391,1.414,0s0.391,1.023,0,1.414L30.708,34.706z"/>
        </g>
    </svg>
)

const submissionIcon = (
    <svg
        stroke="currentColor"
        fill="currentColor"
        strokeWidth="0"
        viewBox="0 0 512 512"
        className="text-[2.5rem] lg:text-[4rem]"
        height="3em"
        width="3em"
        xmlns="http://www.w3.org/2000/svg"
    >
        <g>
            <path d="M417.724,94.564c-0.046-0.073-0.107-0.151-0.197-0.241l-93.08-93.078C323.65,0.448,322.568,0,321.441,0H89.076
		c-7.804,0-14.152,6.348-14.152,14.15v465.393c0,7.804,6.349,14.152,14.152,14.152h315.543c7.804,0,14.152-6.349,14.152-14.152
		V97.328C418.772,96.306,418.387,95.333,417.724,94.564z M325.691,14.511l39.285,39.284l39.284,39.283h-72.917
		c-3.117,0-5.652-2.535-5.652-5.652V14.511z M404.619,485.195H89.076c-3.117,0-5.652-2.536-5.652-5.652V427.43h75.422
		c2.348,0,4.25-1.902,4.25-4.25c0-2.348-1.902-4.25-4.25-4.25H83.424v-49.5h195.422c2.348,0,4.25-1.902,4.25-4.25
		c0-2.348-1.902-4.25-4.25-4.25H83.424V51.43h105.422c2.348,0,4.25-1.902,4.25-4.25c0-2.348-1.902-4.25-4.25-4.25H83.424V14.15
		c0-3.115,2.535-5.65,5.652-5.65h228.115v78.926c0,7.804,6.349,14.152,14.152,14.152h78.928V438.93H262.846
		c-2.348,0-4.25,1.902-4.25,4.25c0,2.348,1.902,4.25,4.25,4.25h147.426v32.113C410.272,482.659,407.736,485.195,404.619,485.195z"/>
            <path d="M321.761,256.968l28.465-28.465c6.945-6.944,6.945-18.245,0-25.189l-90.782-90.781c-3.364-3.365-7.837-5.218-12.595-5.218
		c-4.758,0-9.23,1.853-12.595,5.218l-90.784,90.781c-6.945,6.944-6.945,18.245,0,25.189l28.469,28.469
		c0.797,0.797,1.878,1.245,3.005,1.245c1.127,0,2.208-0.448,3.005-1.245l37.526-37.525l-0.002,91.376
		c0,9.822,7.99,17.813,17.813,17.813h27.125c9.821,0,17.812-7.99,17.812-17.813l0.001-91.382l37.528,37.527
		C317.409,258.628,320.103,258.628,321.761,256.968z M276.978,206.175c-1.215-1.216-3.044-1.579-4.631-0.922
		c-1.589,0.658-2.624,2.208-2.624,3.927l-0.001,101.643c0,5.135-4.177,9.313-9.312,9.313h-27.125c-5.135,0-9.313-4.178-9.313-9.313
		l0.002-101.637c0-1.719-1.035-3.269-2.623-3.927c-0.526-0.218-1.078-0.323-1.626-0.323c-1.106,0-2.193,0.432-3.006,1.245
		l-41.776,41.775l-25.464-25.463c-3.631-3.631-3.631-9.539,0-13.17l90.784-90.781c1.76-1.759,4.098-2.728,6.585-2.728
		c2.487,0,4.825,0.969,6.585,2.728l90.782,90.781c3.631,3.631,3.631,9.539,0,13.17l-25.46,25.459L276.978,206.175z"/>
        </g>
    </svg>
)

const cubeData = [
    {
        id: 1,
        label: 'Participation',
        link: '/teacher/participation',
        text: 'View attendance records',
        icon: calendarIcon
    },
    {id: 2, label: 'Materials', link: '/teacher/material', text: 'Access learning materials', icon: materialIcon},
    {id: 3, label: 'Assignments', link: '/teacher/assignment', text: 'View Tasks', icon: assignmentIcon},
    {id: 4, label: 'Group', link: '/teacher/group', text: 'Manage group activities', icon: groupIcon},
    {id: 5, label: 'Chat', link: '/teacher/chat', text: 'Chat with classmates', icon: chatIcon},
    {id: 6, label: 'Submission', link: '/teacher/submission', text: 'See Submission of Tasks', icon: submissionIcon},
];

const TeacherPage = () => {
    return (
        <div className="cube-container">
            {cubeData.map((cube) => (
                <a key={cube.id} href={cube.link} className="cube">
                    {cube.icon && (
                        <div className="cube-icon">{cube.icon}</div>
                    )}
                    <div className="cube-label"
                         style={cube.label === 'Materials' ? {marginRight: '160px'} : cube.label === 'Group' ? {marginRight: '180px'} : cube.label === 'Chat' ? {marginRight: '180px'} : {}}>{cube.label}</div>

                    <div className="cube-text" style={cube.label === 'Assignments' ? {marginRight: '175px'} : {}}>
                        {cube.text}
                    </div>
                </a>
            ))}
        </div>
    );
};

export default TeacherPage;
